package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Vendor;
import com.app.service.IVendorService;
import com.app.view.VendorExcelView;

@Controller
@RequestMapping("/vendor")
public class VendorController {
	@Autowired
	private IVendorService service;
	
	@RequestMapping("/show")
	public String showData(ModelMap map) {
		map.addAttribute("ven", new Vendor());
		return "VendorRegister";
	}
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insertData(@ModelAttribute("ven")Vendor v,ModelMap map) {
		Integer vId=service.saveVendor(v);
		String msg="Vendor '"+vId+"' Saved";
		map.addAttribute("message", msg);
		map.addAttribute("ven", new Vendor());
		return "VendorRegister";
	}
	
	@RequestMapping("/all")
	public String getAllData(ModelMap map) {
		List<Vendor> vens=service.getAllVendors();
		map.addAttribute("list", vens);
		return "VendorData";
	}
	
	@RequestMapping("/delete")
	public String deleteVendor(@RequestParam("id")Integer vId,ModelMap map) {
		service.deleteVendor(vId);
		List<Vendor> vens=service.getAllVendors();
		String msg="Vendor '"+vId+"' Deleted";
		map.addAttribute("message", msg);
		map.addAttribute("list", vens);
		return "VendorData";
	}
	
	@RequestMapping("/edit")
	public String editVendor(@RequestParam("id")Integer vId,ModelMap map) {
		Vendor v=service.getOneVendorById(vId);
		map.addAttribute("ven",v);
		return "VendorEdit";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(@ModelAttribute("ven")Vendor v,ModelMap map) {
		service.updateVendor(v);
		List<Vendor> vens=service.getAllVendors();
		String msg="Vendor'"+v.getVenId()+"'updated";
		map.addAttribute("message", msg);
		map.addAttribute("list", vens);
		return "VendorData";
	}
	
	@RequestMapping("/excel")
	public ModelAndView excelView() {
		ModelAndView m=new ModelAndView();
		m.setView(new VendorExcelView());
		List<Vendor> vens=service.getAllVendors(); 
		m.addObject("vens", vens);
		return m;
	}
	
	@RequestMapping("/pdf")
	public ModelAndView pdfView() {
		ModelAndView m=new ModelAndView();
		m.setView(null);
		List<Vendor> vens=service.getAllVendors(); 
		m.addObject("vens", vens);
		return m;
	}


}
