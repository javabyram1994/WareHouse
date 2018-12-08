package com.app.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateOptimisticLockingFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;
import com.app.validator.OrderMethodValidator;
import com.app.view.OrderMethodExcelView;

@Controller
@RequestMapping("/ordermethod")
public class OrderMethodController {
	private static final Logger log=Logger.getLogger(OrderMethod.class);
	@Autowired
	private IOrderMethodService service;
	@Autowired
	private OrderMethodValidator validator;
	
	
	@RequestMapping("/show")
	public String saveOderMethod(ModelMap map) {
		map.addAttribute("om", new OrderMethod());
		return "OrderMethodRegister";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insertOrderMethod(@ModelAttribute("om")OrderMethod o,Errors errors,ModelMap map) {
		log.info("enter into insertmethod of oder method");
		validator.validate(o, errors);
		log.info("validations done Successfully");;
		if(!errors.hasErrors()) {
			try {
		Integer omId=service.saveOrderMethod(o);
		String msg="OrderMethod '"+omId+"' inserted";
		log.debug("OrderMethod '"+omId+"' inserted");
		map.addAttribute("message", msg);
		map.addAttribute("om", new OrderMethod());
			}catch(Exception e) {
				log.error(e.getMessage());
				map.addAttribute("message", "please contact admin");
			}
		
		}
		log.info("iam at the end of update method");
		return "OrderMethodRegister";
		
	}
	
	@RequestMapping("/all")
	public String orderMethodData(ModelMap map) {
		log.info("I  entered into Datapage of ordermethod");
	   try {
		List<OrderMethod> oms=service.getAllOrderMethods();
		map.addAttribute("list", oms);
	   }catch(Exception e) {
		   log.error("something went wronh please contact admin");
		   map.addAttribute("message", "please contact admin");
	   }
	   log.info("at the end of get all  order method");
		return "OrderMethodData";
	}
	@RequestMapping("/delete")
	public String OrderMethodDelete(@RequestParam("id")Integer omId,ModelMap map) {
		log.info("at the entry point of delete method");
		String msg=null;
		try {
			if(service.isOrderConnectedWithItem(omId)) {
				msg="OrderMethod is connected with item";
			}else {
		service.deleteOrderMethod(omId);
		msg="OrderMethod '"+omId+"' Deleted";
			}
		}catch(HibernateOptimisticLockingFailureException e) {
			msg="OrderMethod not found";
		}catch(Exception e) {
			log.error(e.getMessage());
			msg="something went wrong please contact admin";
		}
		List<OrderMethod> oms=service.getAllOrderMethods();
		map.addAttribute("message", msg);
		map.addAttribute("list", oms);
		return "OrderMethodData";
	}
	
	@RequestMapping("/edit")
	public String orderMethodEdit(@RequestParam("id")Integer omId,ModelMap map) {
		OrderMethod o=service.getOneOrderMethod(omId);
		map.addAttribute("om", o);
		return "OrderMethodEdit";
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String orderMethodUpdate(@ModelAttribute("om") OrderMethod o,Errors errors,ModelMap map) {
		log.info("iam in edit page");
		validator.validate(o, errors);
		log.info("errors validated sucessfully");
		if(!errors.hasErrors()) {
			log.info("No errors found");
		service.updateOrderMethod(o);
		List<OrderMethod> oms=service.getAllOrderMethods();
		String msg="OrderMethod '"+o.getId()+"'updated";
		map.addAttribute("list", oms);
		map.addAttribute("message", msg);
		return "OrderMethodData";
		}else {
			  log.info("errors found");
			 return "OrderMethodEdit";
		}
		
	}
	
	@RequestMapping("/excel")
	public ModelAndView showExcel() {
		ModelAndView m=new ModelAndView();
		List<OrderMethod> oms=service.getAllOrderMethods();
		//view Details
		m.setView(new OrderMethodExcelView());
		m.addObject("oms", oms);
		return m;
	}
	
	@RequestMapping("/pdf")
	public ModelAndView showPdf() {
		ModelAndView m=new ModelAndView();
		m.setView(null);
		List<OrderMethod> oms=service.getAllOrderMethods();
		m.addObject("oms", oms);
		return m;
	}

}
