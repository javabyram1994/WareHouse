package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.app.model.Item;

@Component
public class ItemValidator implements Validator {


	public boolean supports(Class<?> clazz) {

		return Item.class.equals(clazz);
	}


	public void validate(Object target, Errors errors) {
		Item i=(Item) target;
		
	
		if(!Pattern.compile("[A-Z]{4,8}").matcher(i.getCode()).matches()) {
			errors.rejectValue("code", null, "Enter Valid code(4 to 8 Uppercase only)");
		}

		if(i.getLength() <= 0 || i.getHeight() <= 0 || i.getWidth() <= 0) {
			errors.rejectValue("length", null, "Enter Valid dimensions");
		}
		
		if(i.getBaseCost() <= 0 ) {
			errors.rejectValue("baseCost", null, "Enter Valid Base Cost");
		}
		
		if("".equals(i.getBaseCurrency())) {
			errors.rejectValue("baseCurrency", null, "Please choose Currency");
		}
		
		if(i.getUom() == null || i.getUom().getId() ==null) {
			errors.rejectValue("uom", null, "Please choose one Uom");
		}
		
		if(i.getSaleType() == null || i.getSaleType().getId() ==null) {
			errors.rejectValue("saleType", null, "Please choose one Sale Type");
		}
		
		if(i.getPurchaseType() == null || i.getPurchaseType().getId() ==null) {
			errors.rejectValue("purchaseType", null, "Please choose one Purchase Type");
		}
		
		if(i.getVenUser() == null || i.getVenUser().isEmpty()) {
			errors.rejectValue("venUser", null, "Please choose atleast one Vendor");
		}
		
		if(i.getCustUser() == null || i.getCustUser().isEmpty()) {
			errors.rejectValue("custUser", null, "Please choose one Customer");
		}
		
		if("".equals(i.getDiscr().trim())) {
			errors.rejectValue("discr", null, "Please enter Description");
		}
	}

}
