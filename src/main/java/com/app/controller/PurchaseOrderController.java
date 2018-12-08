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

import com.app.model.PurchaseOrder;
import com.app.model.ShipmentType;
import com.app.model.WhUserType;
import com.app.service.IPurchaseOrderService;
import com.app.service.IShipmentTypeService;
import com.app.service.IWhUserTypeService;
import com.app.validator.PurchaseTypeValidator;

@Controller
@RequestMapping("/purchaseorder")
public class PurchaseOrderController {
	
	@Autowired
	private IPurchaseOrderService service;
	@Autowired
	private IWhUserTypeService whservice;
	@Autowired
	private IShipmentTypeService shservice;
	@Autowired
	private PurchaseTypeValidator validator;
	
	@RequestMapping("/show")
	public String savePurchaseOrder(ModelMap map) {
		
		
		List<WhUserType> vens=whservice.getAllWhUserByType("vendor");
		map.addAttribute("vens", vens);
		List<ShipmentType> codes=shservice.getAllShipmentByType("yes");
		map.addAttribute("codes", codes);
		map.addAttribute("purchase", new PurchaseOrder());
		
		return "PurchaseOrderRegister";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insertPurchase(@ModelAttribute("purchase") PurchaseOrder po,Errors errors,ModelMap map) {
		validator.validate(po, errors);
		if(!errors.hasErrors()) {
		Integer pid=service.savePurchase(po);
		String msg="PurchaseOrder '"+pid+"' saved";
		map.addAttribute("message", msg);
		map.addAttribute("purchase", new PurchaseOrder());
		}
		List<WhUserType> vens=whservice.getAllWhUserByType("vendor");
		map.addAttribute("vens", vens);
		List<ShipmentType> codes=shservice.getAllShipmentByType("code");
		map.addAttribute("codes", codes);
		
		return"PurchaseOrderRegister";
	}
	
	@RequestMapping("/all")
	public String dataPurchase(ModelMap map) {
		List<PurchaseOrder> pos=service.getAllPurchaseOrders();
		map.addAttribute("list", pos);
		return "PurchaseOrderData";
	}
	
	@RequestMapping("/delete")
	public String deletePurchase(@RequestParam("id") Integer pid,ModelMap map) {
		
		service.deletePurchase(pid);
		String msg="Order '"+pid+"' deleted";
		List<PurchaseOrder> pos=service.getAllPurchaseOrders();
		map.addAttribute("list", pos);
		map.addAttribute("message", msg);
		return "PurchaseOrderData";
	}
	
	@RequestMapping("/edit")
	public String editPurchase(@RequestParam("id") Integer pid,ModelMap map) {
		PurchaseOrder po=service.getOnePurchaseOrderById(pid);
		List<WhUserType> vens=whservice.getAllWhUserByType("vendor");
		map.addAttribute("vens", vens);
		List<ShipmentType> codes=shservice.getAllShipmentByType("code");
		map.addAttribute("codes", codes);
		map.addAttribute("purchase", po);
		return "PurchaseOrderEdit";
		
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updatePurchase(@ModelAttribute("purchase") PurchaseOrder po,Errors errors,ModelMap map) {
		validator.validate(po, errors);
		if(!errors.hasErrors()) {
		service.updatePurchase(po);
		String msg="purchaseorder '"+po.getId()+"' updated";
		map.addAttribute("message", msg);
		List<PurchaseOrder> pos=service.getAllPurchaseOrders();
		map.addAttribute("list", pos);
		}else {
			return "PurchaseOrderEdit";
		}
		return "PurchaseOrderData";
	}
	
	

}
