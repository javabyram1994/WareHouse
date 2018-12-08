package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.PurchaseOrder;
@Component
public class PurchaseTypeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return PurchaseOrder.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		PurchaseOrder po = (PurchaseOrder) target;
		if(!Pattern.compile("[A-Za-z]{4,10}").matcher(po.getCode()).matches()) {
			errors.rejectValue("code", null, "please enter valid code(4-10) upper case letters");
		}
		if(!Pattern.compile("[\\w]{4}-[\\w]{4}-[\\w]{4}").matcher(po.getRefNum()).matches()) {
			errors.rejectValue("refNum", null, "Please valid Ref Num enter abcd-defg-hijk");
		}
		if(po.getQuachk().equals("")||po.getQuachk()==null) {
			errors.rejectValue("quachk", null, "Please Select One Radio Button");
		}
		if(!Pattern.compile("[\\w\\s]{10,200}").matcher(po.getDsc()).matches()) {
			errors.rejectValue("dsc", null, "Please Enter Valid Des");
		}
		if(po.getShcode() == null||po.getShcode().getId()==null) {
			errors.rejectValue("shcode", null, "please select one shipmenttype");
		}
		if(po.getVen()==null||po.getVen().getId()==null) {
			errors.rejectValue("ven", null, "please select one shipment");
		}
	}

}
