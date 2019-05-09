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

import com.app.model.Purchase;
import com.app.service.IPurchaseService;
import com.app.service.IShipmentTypeService;
import com.app.service.IWhUserTypeService;
import com.app.util.PurchaseUtil;
import com.app.validator.PurchaseValidator;
import com.app.view.PurchaseExcelView;
import com.app.view.PurchasePdfView;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {

	@Autowired
	private IPurchaseService service;

	@Autowired
	private ServletContext context;
	@Autowired
	private PurchaseUtil util;

	@Autowired
	private PurchaseValidator validator;
	
	@Autowired
	private IShipmentTypeService shipmentservice;
	
	@Autowired
	private IWhUserTypeService whuservice;

	@RequestMapping("/show")
	public String showPage(ModelMap map) {
		map.addAttribute("purchase", new Purchase());
		/**INTEGRATION STARTS**/
		map.addAttribute("ships", shipmentservice.getAllShipmentTypes());
		map.addAttribute("whusers", whuservice.getAllWhUserTypes());
		/**INTEGRATION STARTS**/
		return "PurchaseShowPage";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String showRegPage(@ModelAttribute Purchase purchase, Errors errors, ModelMap map) {

		// CALL VALIDATIONS
		validator.validate(purchase, errors);
		if (!errors.hasErrors()) {
			Integer id = service.savePurchase(purchase);
			map.addAttribute("msg", "Purchase '" + id + "' Saved Successfully");
			map.addAttribute("purchase", new Purchase());
			/**INTEGRATION STARTS**/
			map.addAttribute("ships", shipmentservice.getAllShipmentTypes());
			map.addAttribute("whusers", whuservice.getAllWhUserTypes());
			/**INTEGRATION STARTS**/

		} else {
			map.addAttribute("msg", "Please Check Error");

		}

		return "PurchaseShowPage";
	}
	// Show Data

	@RequestMapping("/all")
	public String showAll(ModelMap map) {
		List<Purchase> oss = service.getAllPurchases();
		map.addAttribute("list", oss);
		return "PurchaseShowDataPage";
	}

	@RequestMapping("/delete")
	public String deleteDataById(@RequestParam("id") Integer sid, ModelMap map) {
		service.deletePurchase(sid);
		map.addAttribute("list", service.getAllPurchases());
		map.addAttribute("msg", sid + "Deleted Successfully");
		return "PurchaseShowDataPage";
	}

	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("id") Integer sid, ModelMap map) {
		Purchase p = service.getPurchaseById(sid);
		map.addAttribute("purchase", p);
		/**INTEGRATION STARTS**/
		map.addAttribute("ships", shipmentservice.getAllShipmentTypes());
		map.addAttribute("whusers", whuservice.getAllWhUserTypes());
		/**INTEGRATION STARTS**/
		return "PurchaseEditPage";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String showUpdatePage(@ModelAttribute Purchase purchase, ModelMap map) {
		service.updatePurchase(purchase);
		List<Purchase> lst = service.getAllPurchases();
		map.addAttribute("list", lst);
		return "PurchaseShowDataPage";
	}

	@RequestMapping("/excel")
	public ModelAndView showExcelPage(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
		ModelAndView m = new ModelAndView();
		m.setView(new PurchaseExcelView());
		if (id == 0) {
			m.addObject("list", service.getAllPurchases());
		} else {
			m.addObject("list", Collections.singletonList(service.getPurchaseById(id)));
		}
		return m;
	}

	@RequestMapping("/pdf")
	public ModelAndView showPdfView(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
		ModelAndView mm = new ModelAndView();
		mm.setView(new PurchasePdfView());
		if (id == 0) {
			mm.addObject("list", service.getAllPurchases());
		} else {
			Purchase pp = service.getPurchaseById(id);
			mm.addObject("list", Collections.singletonList(pp));
		}
		return mm;
	}

	@RequestMapping("/charts")
	public String showCharts() {
		String path = context.getRealPath("/");
		List<Object[]> list = service.getPurchaseCountByQtyCheck();
		System.out.println(path);
		util.generatePie(path, list);
		util.generatePie(path, list);
		return "PurchaseChartPage";
	}

	@RequestMapping("/viewOne")
	public String getRowOne(@RequestParam Integer id, ModelMap map) {
		Purchase pr = service.getPurchaseById(id);
		map.addAttribute("pr", pr);
		return "PurchaseViewPage";
	}

}
