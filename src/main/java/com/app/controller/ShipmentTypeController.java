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

import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;
import com.app.util.ShipmentTypeUtil;
import com.app.validator.ShipmentTypeValidaor;
import com.app.view.ShipmentTypeExcelView;
import com.app.view.ShipmentTypePdfView;

@Controller
@RequestMapping("/shipment")
public class ShipmentTypeController {

	@Autowired
	private IShipmentTypeService service;

	@Autowired
	private ServletContext context;

	@Autowired
	private ShipmentTypeUtil util;

	@Autowired
	private ShipmentTypeValidaor validator;

	// 1.Show Page
	@RequestMapping("/register")
	public String showRegisterPage(ModelMap map) {
		map.addAttribute("shipmentType", new ShipmentType());
		return "ShipRegisterPage";
	}

	// 2.This Method Will Be called on Submit
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveShipment(@ModelAttribute ShipmentType shipmentType, Errors errors, ModelMap mp) {
		// CALL VALIDATOR
		validator.validate(shipmentType, errors);
		if (!errors.hasErrors()) {
			// CALL SERVICE LAYER
			Integer id = service.saveShipmentType(shipmentType);
			mp.addAttribute("msg", "Shipment  '" + id + "' Saved Successfully");
			// CLEAR FORM BACKING OBJECT
			mp.addAttribute("shipmentType", new ShipmentType());

		} else {
			mp.addAttribute("msg", "Please Check Errors");
		}
		return "ShipRegisterPage";
	}

	// 3.Show Data

	@RequestMapping("/all")
	public String showAll(ModelMap map) {
		List<ShipmentType> oss = service.getAllShipmentTypes();
		map.addAttribute("list", oss);
		return "ShipShowDataPage";
	}

	// 4.Delete
	@RequestMapping("/delete")
	public String deleteDataById(@RequestParam("id") Integer sid, ModelMap map) {
		service.deleteShipmentType(sid);
		map.addAttribute("list", service.getAllShipmentTypes());
		map.addAttribute("msg", sid + "Deleted Successfully");
		return "ShipShowDataPage";
	}

	// 5 To Show Edit Page
	@RequestMapping("/edit")
	public String showEdit(@RequestParam("id") Integer sid, ModelMap map) {
		ShipmentType sh = service.getShipmentById(sid);
		map.addAttribute("shipmentType", sh);
		return "ShipShowEditPage";
	}

	// 6 To Update Form Data on Click Submit
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updatePage(@ModelAttribute ShipmentType shipmentType, ModelMap map) {
		service.updateShipementType(shipmentType);
		List<ShipmentType> lts = service.getAllShipmentTypes();
		map.addAttribute("list", lts);
		return "ShipShowDataPage";
	}

	// 7.EXPORT TO EXCEL
	@RequestMapping("/excel")
	public ModelAndView excelExportPage(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
		ModelAndView m = new ModelAndView();
		m.setView(new ShipmentTypeExcelView());
		if (id == 0) {
			m.addObject("list", service.getAllShipmentTypes());
		} else {
			m.addObject("list", Collections.singletonList(service.getShipmentById(id)));
		}
		return m;
	}

	// 8. Export To Pdf
	@RequestMapping("/pdf")
	public ModelAndView pdfExport(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
		ModelAndView mm = new ModelAndView();
		mm.setView(new ShipmentTypePdfView());
		if (id == 0) {
			mm.addObject("list", service.getAllShipmentTypes());
		} else {
			ShipmentType s = service.getShipmentById(id);
			mm.addObject("list", Collections.singletonList(s));
		}
		return mm;
	}

	// 9.SHOW PI & BAR CHARTS
	@RequestMapping("/charts")
	public String showCharts() {
		String path = context.getRealPath("/");
		List<Object[]> list = service.getShipmentCountByMode();
		System.out.println(path);
		util.generatePie(path, list);
		util.generatePie(path, list);
		return "ShipmentTypeReports";
	}

	// 10.VIEW ONE ROW DATA
	@RequestMapping("/viewOne")
	public String getOneRow(@RequestParam Integer id, ModelMap map) {
		ShipmentType st = service.getShipmentById(id);
		map.addAttribute("st", st);
		return "ShipmentViewPage";
	}

}
