package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.model.User;
import com.app.service.IUomService;
import com.app.service.IUserService;

@RequestMapping("/user")
@Controller
public class UserController {
	@Autowired
	private IUserService service;
	
	@RequestMapping("/show")
   public String regUser(ModelMap map) {
	 map.addAttribute("user", new User());
	 return "UserRegister";
   }
   
   @RequestMapping(value="/insert",method=RequestMethod.POST)
   public String insertUser(@ModelAttribute("user") User u,ModelMap map) {
	  map.addAttribute("user", new User());
	  service.saveUser(u);
	  map.addAttribute("message", "User Saved Successfully");
	  return "UserRegister";
   }
}
