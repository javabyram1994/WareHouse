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

import com.app.model.Uom;
import com.app.service.IUomService;
import com.app.validator.UomValidator;
import com.app.view.UomExcelView;

@Controller
@RequestMapping("/uom")
public class UomController {
	
	@Autowired
	private IUomService service;
	@Autowired
	private UomValidator validator;
	private static final Logger log = Logger.getLogger(UomController.class);
	
	@RequestMapping("/home")
	public String uomHomePage() {
		return "Menu";
	}

	@RequestMapping("/show")
	public String uomRegister(ModelMap map) {
		map.addAttribute("uom", new Uom());
		return "UomRegister";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String uomInsert(@ModelAttribute("uom") Uom u, Errors errors, ModelMap map) {
		log.info("enter into insert option of uom");
		validator.validate(u, errors);
		log.info("validation done sucessfully");
		if (!errors.hasErrors()) {
			try {
				Integer uId = service.saveUom(u);
				map.addAttribute("uom", new Uom());
				String msg = "Uom'" + uId + "' Saved";
				log.debug("uom created Sucessfully");
				map.addAttribute("message", msg);
			} catch (Exception e) {
				log.error(e.getMessage());
				String msg="somethig is wrong contact admin";
				map.addAttribute("message", msg);
			}
		}
		log.info("end of the insert method");
		return "UomRegister";
	}

	@RequestMapping("/all")
	public String uomDate(ModelMap map) {
		log.info("Enter into Data method");
		try {
		List<Uom> uoms = service.getAllUoms();
		log.debug("Data retrived sucessfully");
		map.addAttribute("list", uoms);
		}catch(Exception e) {
			log.error(e.getMessage());
			String msg="Something went wrong please contact admin";
			map.addAttribute("message", msg);
		}
		log.info("end of the uomdata method");
		return "UomData";
	}

	@RequestMapping("/delete")
	public String uomDelete(@RequestParam("id") Integer uId, ModelMap map) {
        log.debug("enter into delete block");
		String msg = null;
		try {

			if (service.isUomConnectedWithItem(uId)) {
				msg = "uom cant be deleted becoz connected with item";
			} else {
				service.deleteUom(uId);
				log.debug("uom deleted sucessfully");
				msg = "uom '" + uId + "' Deleted";
			}
		} catch (HibernateOptimisticLockingFailureException e) {
			msg = "uom '" + uId + "' not found";
		} catch (Exception e) {
			log.error(e.getMessage());
			msg="Something went wrong please contact admin";
		}

		map.addAttribute("message", msg);
		List<Uom> uoms = service.getAllUoms();
		map.addAttribute("list", uoms);
	  log.info("end of the uomdelete");
		return "UomData";
		
	}

	@RequestMapping("/edit")
	public String showEdit(@RequestParam("id") Integer uId, ModelMap map) {
		Uom u = service.getOneUomById(uId);
		map.addAttribute("uom", u);
		return "UomEdit";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateUom(@ModelAttribute("uom") Uom u, Errors errors, ModelMap map) {
		log.info("enter into update method");
		validator.validate(u, errors);
		log.info("validations done sucessfully");
		if (!errors.hasErrors()) {
			log.info("no errors found");
			service.updateUom(u);
			List<Uom> uoms = service.getAllUoms();
			String msg = "uom '" + u.getId() + "' updated";
			log.debug("uom updated sucessfully");
			map.addAttribute("list", uoms);
			map.addAttribute("message", msg);
		} else {
			log.info("errors found");
			return "UomEdit";
		}
		log.info("end of the method updateUom");
		return "UomData";
	}

	@RequestMapping("/excel")
	public ModelAndView showExcel() {
		ModelAndView m = new ModelAndView();
		List<Uom> uoms = service.getAllUoms();
		m.setView(new UomExcelView());
		m.addObject("uoms", uoms);
		return m;
	}

	@RequestMapping("/pdf")
	public ModelAndView showPdf() {
		ModelAndView m = new ModelAndView();
		List<Uom> uoms = service.getAllUoms();
		m.setView(null);
		m.addObject("uoms", uoms);
		return m;
	}

}
