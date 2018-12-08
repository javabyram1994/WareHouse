package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;

@Component
public class OrderMethodValidator implements Validator {
	@Autowired
	private IOrderMethodService service;
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return OrderMethod.class.equals(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
       OrderMethod om=(OrderMethod) target;
      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mode", null,"Please Choose Atleast One Mode");
      if(!Pattern.compile("[A-Z0-9]{2,8}").matcher(om.getCode()).matches()) {
    	  errors.rejectValue("code", null, "Please write Valid Code in CapitalLetters(2-8 upper case)");
      }else if(service.isOrderMethodExist(om.getCode())) {
    	  errors.rejectValue("code", null, "Entered code Already Exist");
      }
      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "method", null, "Please Select Atleast One method");
      if(om.getAccept()==null || om.getAccept().isEmpty()) {
    	  errors.rejectValue("accept", null, "Please select atleast One AceeptType");
      }
      if(om.getDsc()==null||om.getDsc().length()<10||om.getDsc().length()>40) {
    	  
    	  errors.rejectValue("dsc", null, "Please enter Atleast 10 charecters and less than 14 charecers");
      }
	}

}
