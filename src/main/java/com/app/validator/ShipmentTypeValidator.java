package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.app.model.ShipmentType;
@Component
public class ShipmentTypeValidator implements Validator {


	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return ShipmentType.class.equals(clazz);
	}

	
	public void validate(Object target, Errors errors) {
		
		ShipmentType sh=(ShipmentType) target;
		if(sh.getMode()==null ||sh.getMode().isEmpty()) {
			errors.rejectValue("mode", null, "Please Choose Atleast one");
		}
		if(!Pattern.compile("[A-Z0-9]{3,9}").matcher(sh.getCode()).matches()) {
			errors.rejectValue("code", null, "Please Enter valid code");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "grade" , null, "Please select any one");
		if(!Pattern.compile("[A-Za-z0-9\\s]{10,200}").matcher(sh.getDsc()).matches()) {
			errors.rejectValue("dsc", null, "Please Enter discription");
		}
		
	}
           
}
