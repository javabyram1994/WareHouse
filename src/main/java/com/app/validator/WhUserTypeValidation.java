package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.app.model.WhUserType;

@Component
public class WhUserTypeValidation implements Validator{
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return WhUserType.class.equals(clazz);
	}
    @Override
    public void validate(Object target, Errors errors) {
       WhUserType whuser=(WhUserType) target;    
       String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
       ValidationUtils.rejectIfEmptyOrWhitespace(errors, "type", null, "Please Choose Any One");
       if(!Pattern.compile("[A-Z0-9]{4,10}").matcher(whuser.getCode()).matches()) {
    	   errors.rejectValue("code", null, "Please Enter Valid Code in Captals(atleast 4-10char)");     
       }
       if(!Pattern.compile("[A-Za-z0-9]{2,8}").matcher(whuser.getForType()).matches()) {
    	   errors.rejectValue("forType", null, "please enter either purchase or sale");
       }
       if(!Pattern.compile(EMAIL_REGEX).matcher(whuser.getEmail()).matches()) {
    	   errors.rejectValue("email", null, "please Enter a valid Email");
       }
       if(!Pattern.compile("[6-9][0-9]{9}").matcher(whuser.getContact()).matches()) {
    	   errors.rejectValue("contact", null, "Please Enter A Valid phone number");
       }
       ValidationUtils.rejectIfEmptyOrWhitespace(errors, "idType", null, "Please select atleast one");
       if(!Pattern.compile("[A-Z0-9]{4,}").matcher(whuser.getIfNum()).matches()) {
    	   errors.rejectValue("ifNum", null, "Please Enter Valid Num");
       }
    }
} 
