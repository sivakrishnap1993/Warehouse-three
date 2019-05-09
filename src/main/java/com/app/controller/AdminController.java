package com.app.controller;

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

import com.app.model.Admin;
import com.app.service.IAdminService;
import com.app.util.AdminUtil;
import com.app.validator.AdminValidator;
import com.app.view.AdminExcelView;
import com.app.view.AdminPdfView;

@Controller
@RequestMapping("/adminpage")
public class AdminController {

	@Autowired
	private IAdminService service;

	@Autowired
	private ServletContext context;

	@Autowired
	private AdminUtil util;

	@Autowired
	private AdminValidator validator;

	@RequestMapping("/show")
	public String showPage(ModelMap map) {
		map.addAttribute("admin", new Admin());
		return "AdminShowPage";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String showRegPage(@ModelAttribute Admin admin, Errors errors, ModelMap map) {
		validator.validate(admin, errors);

		if (!errors.hasErrors()) {
			Integer id = service.saveAdmin(admin);
			map.addAttribute("map", "Admin  '" + id + "' Saved Successfully");
			map.addAttribute("admin", new Admin());

		} else {
			map.addAttribute("map", "Please Check Error");

		}
		return "AdminShowPage";
	}

	// 3.Show Data

	@RequestMapping("/all")
	public String showAll(ModelMap map) {
		List<Admin> oss = service.getAllAdmins();
		map.addAttribute("list", oss);
		return "AdminDataPage";
	}

	// 4.Delete
	@RequestMapping("/delete")
	public String deleteDataById(@RequestParam("id") Integer sid, ModelMap map) {
		service.deleteAdmin(sid);
		map.addAttribute("list", service.getAllAdmins());
		map.addAttribute("msg", sid + "Deleted Successfully");
		return "AdminDataPage";
	}

	// 5 To Show Edit Page
	@RequestMapping("/edit")
	public String showEdit(@RequestParam("id") Integer sid, ModelMap map) {
		Admin sh = service.getAdminById(sid);
		map.addAttribute("admin", sh);
		return "AdminEditPage";
	}

	// 6 To Update Form Data on Click Submit
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updatePage(@ModelAttribute Admin admin, ModelMap map) {
		service.updateAdmin(admin);
		List<Admin> lts = service.getAllAdmins();
		map.addAttribute("list", lts);
		return "AdminDataPage";
	}

	@RequestMapping("/excel")
	public ModelAndView showExcelPage(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
		ModelAndView m = new ModelAndView();
		m.setView(new AdminExcelView());
		if (id == 0) {
			m.addObject("list", service.getAllAdmins());
		} else {
			m.addObject("list", Collections.singletonList(service.getAdminById(id)));
		}
		return m;
	}

	@RequestMapping("/pdf")
	public ModelAndView showPdfPage(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
		ModelAndView mm = new ModelAndView();
		mm.setView(new AdminPdfView());
		if (id == 0) {
			mm.addObject("list", service.getAllAdmins());
		} else {
			Admin a = service.getAdminById(id);
			mm.addObject("list", Collections.singletonList(a));
		}

		return mm;
	}

	@RequestMapping("/charts")
	public String showCharts() {
		String path = context.getRealPath("/");
		List<Object[]> list = service.getAdminCountByDeptMode();
		System.out.println(path);
		util.generatePie(path, list);
		util.generatePie(path, list);
		return "AdminChartPage";
	}

	@RequestMapping("/viewOne")
	public String getRowNum(@RequestParam Integer id, ModelMap map) {
		Admin ad = service.getAdminById(id);
		map.addAttribute("ad", ad);
		return "AdminViewPage";
	}
}
