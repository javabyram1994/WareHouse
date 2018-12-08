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

import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;
import com.app.validator.ShipmentTypeValidator;
import com.app.view.ShipmentTypeExcelView;

@Controller
@RequestMapping("/shipment")
public class ShipmentTypeController {
	@Autowired
	private IShipmentTypeService service;
	@Autowired
	private ShipmentTypeValidator validator;
	
	@RequestMapping("/show")
	public String saveShipment(ModelMap map) {
		map.addAttribute("st",new ShipmentType());
		return "ShipmentTypeRegister";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insertShipmentType(@ModelAttribute("st")ShipmentType s,Errors errors,ModelMap map) {
		validator.validate(s, errors);
		if(!errors.hasErrors()) {
		Integer stId=service.saveShipmentType(s);
		String msg="ShipmentType '"+stId+"' Saved";
		map.addAttribute("st", new ShipmentType());
		map.addAttribute("message", msg);
		}
		return "ShipmentTypeRegister";
	}
	
	@RequestMapping("/all")
	public String showShipmentType(ModelMap map) {
		List<ShipmentType> sts=service.getAllShipmentTypes();
		map.addAttribute("list", sts);
		return "ShipmentTypeData";
	}
	
	@RequestMapping("/delete")
	public String deleteShipmentType(@RequestParam("id")Integer stId,ModelMap map) {
		service.deleteShipmentType(stId);
		List<ShipmentType> sts=service.getAllShipmentTypes();
		String msg="shipment type'"+stId+"'Deleted";
		map.addAttribute("message", msg);
		map.addAttribute("list", sts);
		return "ShipmentTypeData";
	}
	
	@RequestMapping("/edit")
	public String editShipmentType(@RequestParam("id")Integer stId,ModelMap map) {
		ShipmentType s=service.getOneShipmentType(stId);
		map.addAttribute("st", s);
		return "ShipmentTypeEdit";
		
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateShipmentType(@ModelAttribute("st")ShipmentType s,Errors errors,ModelMap map) {
		validator.validate(s, errors);
		if(!errors.hasErrors()) {
		service.updateShipmentType(s);
		List<ShipmentType> sts=service.getAllShipmentTypes();
		String msg="shipment type'"+s.getId()+"'updated";
		map.addAttribute("message", msg);
		map.addAttribute("list", sts);
		}else {
			return "ShipmentTypeEdit";
		}
		return "ShipmentTypeData";
	}
	@RequestMapping("/excel")
	public ModelAndView showExcel() {
		ModelAndView m=new ModelAndView();
		List<ShipmentType> sts=service.getAllShipmentTypes();
		m.setView(new ShipmentTypeExcelView());
		m.addObject("sts", sts);
		return m;
	}
	
	@RequestMapping("/pdf")
	public ModelAndView showPdf() {
		ModelAndView m=new ModelAndView();
		List<ShipmentType> sts=service.getAllShipmentTypes();
		m.setView(null);
		m.addObject("sts", sts);
		return m;
	}

}
