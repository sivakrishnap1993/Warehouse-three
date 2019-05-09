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

import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;
import com.app.util.WhUserUtil;
import com.app.validator.WhUserTypeValidator;
import com.app.view.WHUserTypePdfView;
import com.app.view.WHUsertypeExcelView;

@Controller
@RequestMapping("/whUser")
public class WhUserTypeController {

	@Autowired
	private IWhUserTypeService service;

	@Autowired
	private ServletContext context;

	@Autowired
	private WhUserUtil util;

	@Autowired
	private WhUserTypeValidator validatior;

	@RequestMapping("/register")
	public String showPage(ModelMap map) {
		// form backing object
		map.addAttribute("whUserType", new WhUserType());
		return "WHUserTypeShowPage";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String showRegPage(@ModelAttribute WhUserType whUserType, Errors errors, ModelMap map) {

		// CALL VALIDATOR
		validatior.validate(whUserType, errors);
		if (!errors.hasErrors()) {
			Integer id = service.saveWhUserType(whUserType);
			map.addAttribute("msg", "Warehouse User '" + id + "' Saved Successfully");
			map.addAttribute("whUserType", new WhUserType());// clear form

		} else {
			map.addAttribute("msg", "Please Check Errors");
		}
		return "WHUserTypeShowPage";
	}

	@RequestMapping("/all")
	public String showDataPage(ModelMap map) {
		List<WhUserType> la = service.getAllWhUserTypes();
		map.addAttribute("list", la);
		return "WHUserTypeDataPage";
	}

	@RequestMapping("/delete")
	public String showDeletePage(@RequestParam Integer id, ModelMap map) {
		service.deleteWhUserType(id);
		map.addAttribute("list", service.getAllWhUserTypes());
		map.addAttribute("mes", id + "Record Deleted Successfully");
		map.addAttribute("whUserType", new WhUserType());
		return "WHUserTypeDataPage";
	}

	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("id") Integer sid, ModelMap map) {
		WhUserType e = service.getWhUserTypeById(sid);
		map.addAttribute("whUserType", e);
		return "WHUserTypeEditPage";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String showUpdatePage(@ModelAttribute WhUserType whUserType, ModelMap map) {
		service.updateWhUserType(whUserType);
		List<WhUserType> em = service.getAllWhUserTypes();
		map.addAttribute("list", em);
		return "WHUserTypeDataPage";
	}

	@RequestMapping("/excel")
	public ModelAndView showExcelPage(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
		ModelAndView m = new ModelAndView();
		m.setView(new WHUsertypeExcelView());
		if (id == 0) {
			m.addObject("list", service.getAllWhUserTypes());
		} else {
			m.addObject("list", Collections.singletonList(service.getWhUserTypeById(id)));
		}
		return m;
	}

	@RequestMapping("/pdf")
	public ModelAndView showPdfPage(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
		ModelAndView mm = new ModelAndView();
		mm.setView(new WHUserTypePdfView());
		if (id == 0) {
			mm.addObject("list", service.getAllWhUserTypes());
		} else {
			WhUserType a = service.getWhUserTypeById(id);
			mm.addObject("list", Collections.singletonList(a));
		}

		return mm;
	}

	@RequestMapping("/charts")
	public String showCharts() {
		String path = context.getRealPath("/");
		List<Object[]> list = service.getWhUserTypeCountByMode();
		System.out.println(path);
		util.generatePie(path, list);
		util.generatePie(path, list);
		return "WHUserTypeTypeReports";
	}
	// 5.View One Row or object
		@RequestMapping("/view")
		public String view(@RequestParam(required=false,defaultValue="0") Integer whUserTypeId,ModelMap map) {

			String page=null;
			if (whUserTypeId!=0) {
				map.addAttribute("whUserType", service.getWhUserTypeById(whUserTypeId));
				page = "WHUserViewPage";
			} else {
				map.addAttribute("whUserType", service.getAllWhUserTypes());
				page = "WHUserTypeDataPage";

			}

			return page;
		}

	/*
	 * @RequestMapping("/viewOne") public String getRowOne(@RequestParam Integer id,
	 * ModelMap map) { WhUserType wh = service.getWhUserTypeById(id);
	 * map.addAttribute("whu", wh); return "WHUserViewPage"; }
	 */

}
