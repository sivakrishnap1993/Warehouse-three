package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Shipping;
import com.app.service.IShippingService;

@Component
public class ShippingValidator implements Validator {

	@Autowired 
	private IShippingService shippingService;

	public boolean supports(Class<?> clazz) {
		return Shipping.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {

		Shipping shipping = (Shipping)target;


		//checking text empty
		if (!StringUtils.hasText(shipping.getShipCode().trim())) {
			errors.rejectValue("shipCode", null, "please enter code !");
		} else if (!Pattern.matches("[A-Z]{4,6}", shipping.getShipCode())) {
			errors.rejectValue("shipCode", null, "code shold be 4-6 uppercase lettrs !");
		} else if (shippingService.isShippingCodeExist(shipping.getShipCode())) {
			errors.rejectValue("shipCode", null, "code is already exist !");
		}

		//text check
		if (!StringUtils.hasText(shipping.getShipRefNum().trim())) {
			errors.rejectValue("shipRefNum", null, "please enter reference number !");
		} else if(!Pattern.matches("[A-Za-z0-9]{8,12}", shipping.getShipRefNum())){
			errors.rejectValue("shipRefNum", null, "atleast one digit and one uppercase letter should be 8-12");
		}

		//text check
		if (!StringUtils.hasText(shipping.getCourRefNum().trim())) {
			errors.rejectValue("courRefNum", null, "please enter reference number !");
		} else if(!Pattern.matches("[A-Za-z0-9]{8,12}", shipping.getCourRefNum())){
			errors.rejectValue("courRefNum", null, "atleast one digit and one uppercase letter should be 8-12");
		}

		String MOBILE_REGEX = "[6-9]{1}[\\d]{9}";
		//check mobile (text) is empty or not
		if (!StringUtils.hasText(shipping.getCouCountdtls().trim())) {
			errors.rejectValue("couContdtls", null, "please enter your mobile number !");
		} else if (!Pattern.matches(MOBILE_REGEX, shipping.getCouCountdtls())) {
			errors.rejectValue("couContdtls", null, "please enter valid number !");
		}

		//checking drop down empty
		if (shipping.getSaleOrder()==null || 
				shipping.getSaleOrder().getSaleOrderId()==null || 
				shipping.getSaleOrder().getSaleOrderId()<=0) {
			errors.rejectValue("saleOrder", null, "please choose any one !");
		}


		//checking text area empty and size
		if (!StringUtils.hasText(shipping.getBillAddr().trim())) {
			errors.rejectValue("billAddr", null, "please enter bill address!");
		} else if(shipping.getBillAddr().length()<10 || shipping.getBillAddr().length()>100) {
			errors.rejectValue("billAddr", null, "bill address should be 10-100 characters!");
		}

		//checking text area empty and size
		if (!StringUtils.hasText(shipping.getShipAddr().trim())) {
			errors.rejectValue("shipAddr", null, "please enter shipping address!");
		} else if(shipping.getShipAddr().length()<10 || shipping.getShipAddr().length()>100) {
			errors.rejectValue("shipAddr", null, "shipping address should be 10-100 characters!");
		}
		
		//checking text area empty and size
		if (!StringUtils.hasText(shipping.getShipDesc().trim())) {
			errors.rejectValue("shipDesc", null, "please enter description!");
		} else if(shipping.getShipDesc().length()<10 || shipping.getShipDesc().length()>100) {
			errors.rejectValue("shipDesc", null, "description should be 10-100 characters!");
		}



	}

}
