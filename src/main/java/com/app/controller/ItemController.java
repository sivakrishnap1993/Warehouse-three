package com.app.controller;

import java.util.Collections;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Item;
import com.app.service.IItemService;
import com.app.service.IOrderMethodService;
import com.app.service.IUomService;
import com.app.service.IWhUserTypeService;
import com.app.util.ItemUtil;
import com.app.view.ItemExcelView;
import com.app.view.ItemPdfView;

@Controller
@RequestMapping("/itemspage")
public class ItemController {

	@Autowired
	private IItemService service;

	@Autowired
	private ItemUtil util;

	@Autowired
	private ServletContext context;

	//Integration Starts 
	@Autowired
	private IUomService uomservice;

	@Autowired
	private IOrderMethodService ormservice;

	@Autowired
	private IWhUserTypeService venwhservice;
	
	@Autowired
	private IWhUserTypeService custwhservice;
	//Integration ends 
	
	@RequestMapping("/show")
	public String showRegPage(ModelMap mp) {
		/** Integration Starts **/
		mp.addAttribute("uoms", uomservice.getAllUoms());
		mp.addAttribute("orms", ormservice.getAllOrderMethods());
		/**WHUSER-TYPE INTEGRATION RADIO-BUTTONS STARTS**/
		mp.addAttribute("vens", venwhservice.getWhUsersBasedonType("Vendor"));
		System.err.println(venwhservice.getWhUsersBasedonType("Vendor"));
		mp.addAttribute("custs", custwhservice.getWhUsersBasedonType("Customer"));
		System.err.println(custwhservice.getWhUsersBasedonType("Customer"));
		/**WHUSER-TYPE INTEGRATION RADIO-BUTTONS STARTS**/
		/** Integration Ends **/
		mp.addAttribute("item", new Item());
		return "ItemRegPage";
	}

	// 2.This Method Will Be called on Submit
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveItem(@ModelAttribute Item item, ModelMap mp) {
		Integer id = service.saveItem(item);
		mp.addAttribute("msg", "Items  '" + id + "' Saved Successfully");
		// CLEAR FORM BACKING OBJECT
		mp.addAttribute("item", new Item());
		/** Integration Starts **/
		mp.addAttribute("uoms", uomservice.getAllUoms());
		mp.addAttribute("orms", ormservice.getAllOrderMethods());
		mp.addAttribute("vens", venwhservice.getWhUsersBasedonType("Vendor"));
		System.err.println(venwhservice.getWhUsersBasedonType("Vendor"));
		mp.addAttribute("custs", custwhservice.getWhUsersBasedonType("Customer"));
		System.err.println(custwhservice.getWhUsersBasedonType("Customer"));
		/** Integration Ends **/
		return "ItemRegPage";
	}

	// 3.Show Data

	@RequestMapping("/all")
	public String showAll(ModelMap map) {
		List<Item> oss = service.getAllItems();
		map.addAttribute("list", oss);
		return "ItemDataPage";
	}

	// 4.Delete
	@RequestMapping("/delete")
	public String deleteDataById(@RequestParam("id") Integer sid, ModelMap map) {
		
		try {
			service.deleteItem(sid);
			map.addAttribute("list", service.getAllItems());
			map.addAttribute("message", sid + "Deleted Successfully");
		} catch (Exception e) {
			map.addAttribute("message", sid + "No Data Will be Deleted ");
		}
		
		return "ItemDataPage";
	}

	// 5 To Show Edit Page
	@RequestMapping("/edit")
	public String showEdit(@RequestParam("id") Integer sid, ModelMap map) {
		Item sh = service.getItemById(sid);
		map.addAttribute("item", sh);
		/** Integration Starts **/
		map.addAttribute("uoms", uomservice.getAllUoms());
		map.addAttribute("orms", ormservice.getAllOrderMethods());
		/** Integration Ends **/
		
		/**WHUSER-TYPE INTEGRATION STARTS**/
		map.addAttribute("vens", venwhservice.getWhUsersBasedonType("Vendor"));
		System.err.println(venwhservice.getWhUsersBasedonType("Vendor"));
		map.addAttribute("custs", custwhservice.getWhUsersBasedonType("Customer"));
		System.err.println(custwhservice.getWhUsersBasedonType("Customer"));
		/**WHUSER-TYPE INTEGRATION ENDS**/
		return "ItemEditPage";
	}

	// 6 To Update Form Data on Click Submit
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updatePage(@ModelAttribute Item item, ModelMap map) {
		service.updateItem(item);
		List<Item> lts = service.getAllItems();
		map.addAttribute("list", lts);
		return "ItemDataPage";
	}

	// 7.EXPORT TO EXCEL
	@RequestMapping("/excel")
	public ModelAndView excelExportPage(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
		ModelAndView m = new ModelAndView();
		m.setView(new ItemExcelView());
		if (id == 0) {
			m.addObject("list", service.getAllItems());
		} else {
			m.addObject("list", Collections.singletonList(service.getItemById(id)));
		}
		return m;
	}

	// 8. Export To Pdf
	@RequestMapping("/pdf")
	public ModelAndView pdfExport(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
		ModelAndView mm = new ModelAndView();
		mm.setView(new ItemPdfView());
		if (id == 0) {
			mm.addObject("list", service.getAllItems());
		} else {
			Item s = service.getItemById(id);
			mm.addObject("list", Collections.singletonList(s));
		}
		return mm;
	}

	// 9.SHOW PI & BAR CHARTS
	@RequestMapping("/charts")
	public String showCharts() {
		String path = context.getRealPath("/");
		List<Object[]> list = service.getCountByMode();
		System.out.println(path);
		util.generatePie(path, list);
		util.generatePie(path, list);
		return "ItemReports";
	}

	// 10.VIEW ONE ROW DATA
	@RequestMapping("/viewOne")
	public String getOneRow(@RequestParam Integer id, ModelMap map) {
		Item st = service.getItemById(id);
		map.addAttribute("st", st);
		return "ItemViewPage";
	}

}
