package com.app.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.User;
import com.app.service.IUserService;
import com.app.util.EmailUtil;
import com.app.util.UserViewUtil;
import com.app.validator.UserValidator;
import com.app.view.UserExcelView;
import com.app.view.UserPdfView;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService service;

	@Autowired
	private ServletContext context;

	@Autowired
	private UserViewUtil util;

	@Autowired
	private UserValidator validator;
	
	@Autowired
	private EmailUtil emailUtil;

	@RequestMapping("/register")
	public String showRegPage(ModelMap map) {
		map.addAttribute("user", new User());
		return "UserShowPage";
	}

	//2.insert user details in Db
		@RequestMapping(value="/insert",method=RequestMethod.POST)
		public String saveUserDetails(@ModelAttribute User user,Errors errors,ModelMap map) {

			validator.validate(user, errors);

			if (errors.hasErrors()) {
				map.addAttribute("message", "please check all fields !!");
			} else {
				String pwd=user.getUsrPwd();
				Integer userId=service.saveUser(user);
				String message=user.getUsrName()+" saved with Id :"+userId;
				map.addAttribute("user", new User());
				
				//email config start
				String text="Hello! " + user.getUsrName()
				+ " , welcome to Warehouse App.. Your user name is: " + user.getUsrMail()
				+ " , Password is : " + pwd
				+ " , Your Roles are : " +user.getUsrRoles();
				
				boolean flag=emailUtil.sendEmail(user.getUsrMail(), "Welcome to App User!!", text);
				if(flag)
					message+=", Email also sent!!";
				else
					message+=", Email sending is failed!!";
				//email config end
				
				map.addAttribute("message", message);
			}
		return "UserShowPage";
	}
	
	/*
	 * @RequestMapping("/all") public String showAllPages(ModelMap map) { List<User>
	 * ls = service.getAllUsers(); map.addAttribute("list", ls); return
	 * "UserDataPage"; }
	 */

	@RequestMapping("/delete")
	public String deleteDataById(@RequestParam("id") Integer sid, ModelMap map) {
		try {
			//delete one row
			service.deleteUser(sid);
			map.addAttribute("message", "One User with Id "+sid+" Successfully deleted");
		} catch (Exception e) {
			map.addAttribute("message", "No details found with Id : "+sid);
		}
		map.addAttribute("list", service.getAllUsers());
		return "UserDataPage";
	}
	
	//5.view one user da=etails
		@RequestMapping("/view")
		public String viewOne(@RequestParam(required=false,defaultValue="0") Integer userId,ModelMap map) {

			String page=null;
			if (userId!=0) {
				// load one user data and send to UI
				map.addAttribute("user", service.getUserById(userId));
				page = "UserViewPage";

			} else {
				// load one user data and send to UI
				map.addAttribute("user", service.getAllUsers());
				page = "UserDataPage";
			}

			return page;
		}


	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("id") Integer sid, ModelMap map) {
		User e = service.getUserById(sid);
		map.addAttribute("user", e);
		return "UserEditPage";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String showUpdatePage(@ModelAttribute User user, ModelMap map) {
		service.updateUser(user);
		List<User> em = service.getAllUsers();
		map.addAttribute("list", em);
		return "UserDataPage";
	}

	//8.export excel
	@RequestMapping("/excelExport")
	public ModelAndView exportOneUserToExcel(@RequestParam(required=false,defaultValue="0") Integer userId) {

		if (userId!=0) {
			return new ModelAndView(new UserExcelView(),"user",Arrays.asList(service.getUserById(userId)));

		} else {
			return new ModelAndView(new UserExcelView(),"user",service.getAllUsers());

		}
		//return new ModelAndView(new UserExcelView(),"user",Arrays.asList(service.getUserById(userId)));
	}
	
	/*
	 * @RequestMapping("/excel") public ModelAndView
	 * showExcelPage(@RequestParam(value = "id", defaultValue = "0", required =
	 * false) Integer id) { ModelAndView m = new ModelAndView(); m.setView(new
	 * UserExcelView()); if (id == 0) { m.addObject("list", service.getAllUsers());
	 * } else { m.addObject("list",
	 * Collections.singletonList(service.getUserById(id))); } return m; }
	 */

	@RequestMapping("/pdf")
	public ModelAndView showpdfView(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
		ModelAndView mm = new ModelAndView();
		mm.setView(new UserPdfView());
		if (id == 0) {
			mm.addObject("list", service.getAllUsers());
		} else {
			User e = service.getUserById(id);
			mm.addObject("list", Collections.singletonList(e));
		}

		return mm;
	}

	@RequestMapping("/charts")
	public String showCharts() {
		String path = context.getRealPath("/");
		List<Object[]> list = service.getUserCountByMode();
		System.out.println(path);
		util.generatePie(path, list);
		util.generateBar(path, list);
		return "UserChartPage";
	}

	/*
	 * @RequestMapping("/viewOne") public String getRowNum(@RequestParam Integer id,
	 * ModelMap map) { User us = service.getUserById(id); map.addAttribute("us",
	 * us); return "UserViewPage"; }
	 */
}
