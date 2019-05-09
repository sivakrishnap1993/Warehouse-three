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

import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;
import com.app.util.OrderMethodUtil;
import com.app.validator.OrderMethodValidator;
import com.app.view.OrderMethodExcelView;
import com.app.view.OrderMethodPdfView;

@Controller
@RequestMapping("/ordermethod")
public class OrderMethodController {

	@Autowired
	private IOrderMethodService service;

	@Autowired
	private ServletContext context;

	@Autowired
	private OrderMethodUtil util;

	@Autowired
	private OrderMethodValidator validator;

	@RequestMapping("/show")
	public String showPage(ModelMap map) {
		map.addAttribute("orderMethod", new OrderMethod());
		return "OrderMethodShowPage";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String showRegPage(@ModelAttribute OrderMethod orderMethod, Errors errors, ModelMap map) {

		// CALL VALIDATION
		validator.validate(orderMethod, errors);

		if (!errors.hasErrors()) {
			Integer id = service.saveOrderMethod(orderMethod);
			map.addAttribute("clg", "Order Is'" + id + "' Saved Successfully ");
			map.addAttribute("orderMethod", new OrderMethod());
		} else {
			map.addAttribute("clg", "Please Check Error");
		}
		return "OrderMethodShowPage";
	}

	@RequestMapping("/all")
	public String showOrderPage(ModelMap map) {
		List<OrderMethod> ls = service.getAllOrderMethods();
		map.addAttribute("list", ls);
		return "OrderMethodDataPage";
	}

	@RequestMapping("/delete")
	public String deleteDataById(@RequestParam("id") Integer sid, ModelMap map) {
		service.deleteOrderMethod(sid);
		map.addAttribute("list", service.getAllOrderMethods());
		map.addAttribute("msg", sid + "Deleted Successfully");
		return "OrderMethodDataPage";
	}

	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("id") Integer sid, ModelMap map) {
		OrderMethod e = service.getOrderMethodById(sid);
		map.addAttribute("orderMethod", e);
		return "OrderMethodEditPage";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String showUpdatePage(@ModelAttribute OrderMethod orderMethod, ModelMap map) {
		service.updateOrderMethod(orderMethod);
		List<OrderMethod> em = service.getAllOrderMethods();
		map.addAttribute("list", em);
		return "OrderMethodDataPage";
	}

	@RequestMapping("/excel")
	public ModelAndView showExcelPage(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
		ModelAndView m = new ModelAndView();
		m.setView(new OrderMethodExcelView());
		if (id == 0) {
			m.addObject("list", service.getAllOrderMethods());
		} else {
			m.addObject("list", Collections.singletonList(service.getOrderMethodById(id)));
		}
		return m;
	}

	@RequestMapping("/pdf")
	public ModelAndView showPdfPage(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
		ModelAndView mm = new ModelAndView();
		mm.setView(new OrderMethodPdfView());
		if (id == 0) {
			mm.addObject("list", service.getAllOrderMethods());
		} else {
			OrderMethod a = service.getOrderMethodById(id);
			mm.addObject("list", Collections.singletonList(a));
		}

		return mm;
	}
	@RequestMapping("/charts")
	public String showCharts() {
		String path=context.getRealPath("/");
		List<Object[]> list=service.getOrderMethodCountByMode();
		util.genereatePie(path, list);
		util.genereatePie(path, list);
		return "OrderMethodReports" ;
	}
	

	@RequestMapping("/viewOne")
	public String getRowOne(@RequestParam Integer id, ModelMap map) {
		OrderMethod orm = service.getOrderMethodById(id);
		map.addAttribute("md", orm);
		return "OrderMethodViewPage";
	}

}
