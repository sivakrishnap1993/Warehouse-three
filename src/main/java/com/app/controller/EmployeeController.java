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

import com.app.model.Employee;
import com.app.service.IEmployeeService;
import com.app.util.EmployeeUtil;
import com.app.validator.EmployeeValidator;
import com.app.view.EmployeeExcelView;
import com.app.view.EmployeePdfView;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private IEmployeeService service;

	@Autowired
	private ServletContext context;

	@Autowired
	private EmployeeUtil util;

	@Autowired
	private EmployeeValidator validator;

	@RequestMapping("/show")
	public String showPage(ModelMap map) {
		map.addAttribute("employee", new Employee());
		return "EmployeeShowPage";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String showRegPage(@ModelAttribute Employee employee, Errors errors, ModelMap map) {
		// CALL VALIDATION
		validator.validate(employee, errors);

		if (!errors.hasErrors()) {
			// CALL SERVICE METHOD
			Integer id = service.saveEmployee(employee);
			map.addAttribute("one", "Employee List '" + id + "' Was Successfully Saved");
			map.addAttribute("employee", new Employee());
		} else {
			map.addAttribute("one", "Please Check The Errors");

		}
		return "EmployeeShowPage";
	}

	@RequestMapping("/all")
	public String showAllPages(ModelMap map) {
		List<Employee> ls = service.getAllEmployees();
		map.addAttribute("list", ls);
		return "EmployeeDataPage";
	}

	@RequestMapping("/delete")
	public String deleteDataById(@RequestParam("id") Integer sid, ModelMap map) {
		service.deleteEmplyee(sid);
		map.addAttribute("list", service.getAllEmployees());
		map.addAttribute("msg", sid + "Deleted Successfully");
		return "EmployeeDataPage";
	}

	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("id") Integer sid, ModelMap map) {
		Employee e = service.getEmployeeById(sid);
		map.addAttribute("employee", e);
		return "EmployeeEditPage";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String showUpdatePage(@ModelAttribute Employee employee, ModelMap map) {
		service.updateEmployee(employee);
		List<Employee> em = service.getAllEmployees();
		map.addAttribute("list", em);
		return "EmployeeDataPage";
	}

	@RequestMapping("/excel")
	public ModelAndView showExcelPage(@RequestParam(value = "id", defaultValue = "0", required = false) Integer id) {
		ModelAndView m = new ModelAndView();
		m.setView(new EmployeeExcelView());
		if (id == 0) {
			m.addObject("list", service.getAllEmployees());
		} else {
			m.addObject("list", Collections.singletonList(service.getEmployeeById(id)));
		}
		return m;
	}

	@RequestMapping("/pdf")
	public ModelAndView showpdfView(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
		ModelAndView mm = new ModelAndView();
		mm.setView(new EmployeePdfView());
		if (id == 0) {
			mm.addObject("list", service.getAllEmployees());
		} else {
			Employee e = service.getEmployeeById(id);
			mm.addObject("list", Collections.singletonList(e));
		}

		return mm;
	}

	@RequestMapping("/charts")
	public String showCharts() {
		String path = context.getRealPath("/");
		List<Object[]> list = service.getEmployeeCountByGenMode();
		System.out.println(path);
		util.generatePie(path, list);
		util.generateBar(path, list);
		return "EmployeeChartPage";
	}

	@RequestMapping("/viewOne")
	public String getRowNum(@RequestParam Integer id, ModelMap map) {
		Employee emp = service.getEmployeeById(id);
		map.addAttribute("emp", emp);
		return "EmployeeViewPage";
	}
}
