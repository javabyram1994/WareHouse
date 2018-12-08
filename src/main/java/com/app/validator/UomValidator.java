package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Uom;
import com.app.service.IUomService;
@Component
public class UomValidator implements Validator{
	
	@Autowired
	private IUomService service;

	@Override
	public boolean supports(Class<?> clazz) {
		return Uom.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
    Uom uom=(Uom) target;
    if("".equals(uom.getType())) {
    	errors.rejectValue("type", null, "Please Choose any Type");
    }
    if(!Pattern.compile("[A-Za-z0-9]{4,10}").matcher(uom.getModel().trim()).matches()) {
    	errors.rejectValue("model", null, "Please Enter Valid Model(atleast 4-10)");
    }else if(service.isUomModelExist(uom.getModel())) {
    	errors.rejectValue("model", null, "Uom model already exists,Please xhooseOther");
    }
    if(!Pattern.compile("[A_Za-z0-9\\s]{10,200}").matcher(uom.getDsc().trim()).matches()) {
    	errors.rejectValue("dsc", null, "Please Enter dsc (atleast 10-200)");
    }
	}

}
