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

import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;
import com.app.validator.WhUserTypeValidation;
import com.app.view.WhUserTypeExcelView;

@Controller
@RequestMapping("/whuser")
public class WhUserTypeController {
	@Autowired
	private IWhUserTypeService service;
	@Autowired
	private WhUserTypeValidation validator;
	
	@RequestMapping("/show")
	public String showWhUser(ModelMap map) {
		map.addAttribute("whu", new WhUserType());
		return "WhUserTypeRegister";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insertWhUser(@ModelAttribute("whu")WhUserType wh,Errors errors,ModelMap map) {
		validator.validate(wh, errors);
		if(!errors.hasErrors()) {
		Integer whId=service.saveWhUser(wh);
		String msg="WhUserType '"+whId+"' inserted";
		map.addAttribute("message", msg);
		map.addAttribute("whu", new WhUserType());
		}else {
			map.addAttribute("message", "please Enter valid details");
		}
		return "WhUserTypeRegister";
	}
	
	@RequestMapping("/all")
	public String whUserData(ModelMap map) {
		List<WhUserType> whs=service.getAllWhUsers();
		map.addAttribute("list", whs);
		return "WhUserTypeData";
	}
	
	@RequestMapping("/delete")
	public String whUserTypeDelete(@RequestParam("id")Integer whId,ModelMap map) {
		service.deleteWhuser(whId);
		List<WhUserType> whs=service.getAllWhUsers();
		String msg="Whuser '"+whId+"' Deleted";
		map.addAttribute("list", whs);
		map.addAttribute("message", msg);
		return "WhUserTypeData";
	}
	
	@RequestMapping("/edit")
	public String whUserTypeEdit(@RequestParam("id")Integer whId,ModelMap map) {
		WhUserType wh=service.getOneWhuser(whId);
		map.addAttribute("whu", wh);
		return "WhUserTypeEdit";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String whuserTypeUpdate(@ModelAttribute("whu")WhUserType wh,Errors errors,ModelMap map) {
		validator.validate(wh, errors);
		if(!errors.hasErrors()) {
	   service.updateWhUser(wh);
	   List<WhUserType> whs=service.getAllWhUsers();
	   String msg="WhUserType '"+wh.getId()+"' updated";
	   map.addAttribute("message", msg);
		map.addAttribute("list", whs);
		}else {
			return "WhUserTypeEdit";	
		}
	   return "WhUserTypeData";
	}
	@RequestMapping("/excel")
	public ModelAndView showExcel() {
		ModelAndView m=new ModelAndView();
		List<WhUserType> whs=service.getAllWhUsers();
		m.setView(new WhUserTypeExcelView());
		m.addObject("whs", whs);
		return m;
	}
	@RequestMapping("/pdf")
	public ModelAndView showPdf() {
		ModelAndView m=new ModelAndView();
		List<WhUserType> whs=service.getAllWhUsers();
		m.setView(null);
		m.addObject("whs", whs);
		return m;
	}

}
