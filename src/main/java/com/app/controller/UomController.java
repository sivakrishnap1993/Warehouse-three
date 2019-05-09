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

import com.app.model.Uom;
import com.app.service.IUomService;
import com.app.util.UomUtil;
import com.app.validator.UomValidator;
import com.app.view.UomExcelView;
import com.app.view.UomPdfView;

@Controller
@RequestMapping("/uom")
public class UomController {

	@Autowired
	private IUomService service;

	@Autowired
	private ServletContext context;

	@Autowired
	private UomUtil util;

	@Autowired
	private UomValidator validatior;

	// 1.Show Data
	@RequestMapping("/register")
	public String showPage(ModelMap map) {
		map.addAttribute("uom", new Uom());
		return "UomShowPage";
	}

	// 2.Save Data To Db
	@RequestMapping("/save")
	public String updatePage(@ModelAttribute Uom uom, Errors errors, ModelMap map) {

		// CALL VALIDATOR
		validatior.validate(uom, errors);

		if (!errors.hasErrors()) {
			Integer id = service.saveUom(uom);
			map.addAttribute("message", "Uom Page '" + id + "' Saved Successfull");
			map.addAttribute("uom", new Uom());
		} else {
			map.addAttribute("message", "Please Check Errors");
		}
		return "UomShowPage";
	}

	// 3.Show All Data Pages
	@RequestMapping("/all")
	public String showAllPages(ModelMap map) {
		List<Uom> ls = service.getAllUoms();
		map.addAttribute("list", ls);
		return "UomDataPage";
	}

	// 4.Delete Page
	@RequestMapping("/delete")
	public String deleteDataById(@RequestParam Integer id, ModelMap map) {
		service.deleteUom(id);
		map.addAttribute("msg", id + "Deleted Successfully");
		map.addAttribute("list", service.getAllUoms());
		return "UomDataPage";
	}

	// 5.EDIT PAGE
	@RequestMapping("/edit")
	public String showEdit(@RequestParam("id") Integer sid, ModelMap map) {
		Uom sh = service.getUomById(sid);
		map.addAttribute("uom", sh);
		return "UomEditPage";
	}

	// 6. UPDATE PAGE
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute Uom uom, ModelMap map) {
		service.updateUom(uom);
		List<Uom> u = service.getAllUoms();
		map.addAttribute("list", u);

		return "UomDataPage";
	}

	// 7.EXPORT TO EXCEL
	@RequestMapping("/excel")
	public ModelAndView excelExportPage(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
		ModelAndView m = new ModelAndView();
		m.setView(new UomExcelView());
		if (id == 0) {
			m.addObject("list", service.getAllUoms());
		} else {
			m.addObject("list", Collections.singletonList(service.getUomById(id)));
		}
		return m;
	}

	// 8. EXPORT DATA TO PDF FORM
	@RequestMapping("/pdf")
	public ModelAndView pdfExport(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
		ModelAndView m = new ModelAndView();
		// set view object
		m.setView(new UomPdfView());
		if (id == 0) {
			m.addObject("list", service.getAllUoms());
		} else {
			Uom u = service.getUomById(id);
			m.addObject("list", Collections.singletonList(u));
		}
		return m;
	}

	// 9. Pi Charts
	@RequestMapping("/charts")
	public String showCharts() {
		String path = context.getRealPath("/");
		List<Object[]> list = service.getUomCountByType();
		System.out.println(path);
		util.generatePie(path, list);
		util.generatePie(path, list);
		return "UomChartPage";
	}

	// 10.GET ROW NUMBER
	@RequestMapping("/viewOne")
	public String getRowNum(@RequestParam Integer id, ModelMap map) {
		Uom u = service.getUomById(id);
		map.addAttribute("us", u);
		return "UomViewPage";
	}

}
