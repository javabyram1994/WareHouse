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

import com.app.model.Customer;
import com.app.service.ICustomerService;
import com.app.view.CustomerExcelView;
@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private ICustomerService service;
	
	@RequestMapping("/show")
	public String showCustomer(ModelMap map) {
		map.addAttribute("cust", new Customer());
		return "CustomerRegister";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("cust")Customer c,ModelMap map) {
		Integer cId=service.saveCustomer(c);
		String msg="Customer '"+cId+"' Svaed";
		map.addAttribute("message", msg);
		map.addAttribute("cust", new Customer());
		return "CustomerRegister";
	}
	
   @RequestMapping("/all")
   public String getData(ModelMap map) {
	   List<Customer> custs=service.getAllCustomers();
	   map.addAttribute("list", custs);
	   return "CustomerData";
   }
   
   @RequestMapping("/delete")
   public String deleteCustomer(@RequestParam("id")Integer cId,ModelMap map) {
	   service.deleteCustomer(cId);
	   List<Customer> custs=service.getAllCustomers();
	   String msg="Customer '"+cId+"' Deleted";
	   map.addAttribute("message", msg);
	   map.addAttribute("list", custs);
	   return "CustomerData";
   }
   
   @RequestMapping("/edit")
   public String editCustomer(@RequestParam("id")Integer cId,ModelMap map) {
	   Customer c=service.getOneCustomerById(cId);
		map.addAttribute("cust", c);
		return "CustomerEdit"; 
   }
   
   
   
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String editCust(@ModelAttribute("cust")Customer c,ModelMap map) {
		service.updateCustomer(c);
		 List<Customer> custs=service.getAllCustomers();
		   String msg="Customer '"+c.getCustId()+"' updated";
		   map.addAttribute("message", msg);
		   map.addAttribute("list", custs);
		   return "CustomerData";
	}
	@RequestMapping("/excel")
	public ModelAndView excelView() {
		ModelAndView m=new ModelAndView();
		m.setView(new CustomerExcelView());
		List<Customer> custs=service.getAllCustomers();
		m.addObject("custs", custs);
		return m;
	}
	@RequestMapping("/pdf")
	public ModelAndView pdfView() {
		ModelAndView m=new ModelAndView();
		m.setView(null);
		List<Customer> custs=service.getAllCustomers();
		m.addObject("custs", custs);
		return m;
	}
	
}
