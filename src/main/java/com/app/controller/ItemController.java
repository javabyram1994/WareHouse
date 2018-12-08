package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Item;
import com.app.model.OrderMethod;
import com.app.model.Uom;
import com.app.model.WhUserType;
import com.app.service.IItemService;
import com.app.service.IOrderMethodService;
import com.app.service.IUomService;
import com.app.service.IWhUserTypeService;
import com.app.validator.ItemValidator;
import com.app.view.ItemExcelView;

@RequestMapping("/item")
@Controller
public class ItemController {
	@Autowired
	private IItemService service;
	@Autowired
	private IUomService uservice;
	@Autowired
	private IOrderMethodService omservice;
	
	@Autowired
	private IWhUserTypeService whservice;
	
	@Autowired
	private ItemValidator validator;

	@RequestMapping("/show")
	public String saveItem(ModelMap map) {
		
		List<Uom> uoms=uservice.getAllUoms();
		map.addAttribute("uoms", uoms);
		List<OrderMethod> oms=omservice.getAllOderMethodByMode("sale");
		map.addAttribute("oms", oms);
		List<OrderMethod> omp=omservice.getAllOderMethodByMode("purchase");
		map.addAttribute("omp", omp);
		
		List<WhUserType> vens=whservice.getAllWhUserByType("vendor");
		map.addAttribute("vens", vens);
		
		List<WhUserType> custs=whservice.getAllWhUserByType("customer");
		map.addAttribute("custs", custs);
		map.addAttribute("item", new Item());
		return "ItemRegister";

	}
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insertItem(@ModelAttribute("item")Item i,Errors errors,ModelMap map) {
		validator.validate(i, errors);
		if(!errors.hasErrors()) {
			
			Integer iId=service.saveItem(i);
			String msg="item'"+iId+"' saved";
			map.addAttribute("message", msg);
			map.addAttribute("item", new Item());
		}
		List<Uom> uoms=uservice.getAllUoms();
		map.addAttribute("uoms", uoms);
		List<OrderMethod> oms=omservice.getAllOderMethodByMode("sale");
		map.addAttribute("oms", oms);
		List<OrderMethod> omp=omservice.getAllOderMethodByMode("purchase");
		map.addAttribute("omp", omp);
		
		List<WhUserType> vens=whservice.getAllWhUserByType("vendor");
		map.addAttribute("vens", vens);
		
		List<WhUserType> custs=whservice.getAllWhUserByType("customer");
		map.addAttribute("custs", custs);
		
		
		return "ItemRegister";

	}

	@RequestMapping("/all")
	public String dataItem(ModelMap map) {
		List<Item> its=service.getAllItems();
		map.addAttribute("list", its);
		return "ItemData";
	}

	@RequestMapping("/delete")
	public String deleteItem(@RequestParam("id")Integer iId,ModelMap map) {
		service.deleteItem(iId);
		String msg="Item '"+iId+"' Deleted";
		List<Item> its=service.getAllItems();
		map.addAttribute("message", msg);
		map.addAttribute("list", its);
		return "ItemData";
	}


	@RequestMapping("/edit")
	public String editItem(@RequestParam("id")Integer iId,ModelMap map) {
		Item i=service.getOneItemById(iId);
		List<Uom> uoms=uservice.getAllUoms();
		map.addAttribute("uoms", uoms);
		List<OrderMethod> oms=omservice.getAllOderMethodByMode("sale");
		map.addAttribute("oms", oms);
		List<OrderMethod> omp=omservice.getAllOderMethodByMode("purchase");
		map.addAttribute("omp", omp);
		
		List<WhUserType> vens=whservice.getAllWhUserByType("vendor");
		map.addAttribute("vens", vens);
		
		List<WhUserType> custs=whservice.getAllWhUserByType("customer");
		map.addAttribute("custs", custs);
		map.addAttribute("item", i);
		return "ItemEdit";
	}

	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateItem(@ModelAttribute("item")Item i,Errors errors,ModelMap map) {
		validator.validate(i, errors);
		if(!errors.hasErrors()) {
		service.updateItem(i);
		List<Item> its=service.getAllItems();
		map.addAttribute("list",its);
		String msg="Item'"+i.getId()+"' Updated";
		map.addAttribute("message", msg);
		}else {
			return "ItemEdit";
		}
		return "ItemData";

	}

	@RequestMapping("/excel")
	public ModelAndView excelView() {
		ModelAndView m=new ModelAndView();
		m.setView(new ItemExcelView());
		List<Item> items=service.getAllItems();
		m.addObject("items", items);
		return m;
	}
	@RequestMapping("/pdf")
	public ModelAndView pdfView() {
		ModelAndView m=new ModelAndView();
		m.setView(null);
		List<Item> items=service.getAllItems();
		m.addObject("items", items);
		return m;
	}
}
