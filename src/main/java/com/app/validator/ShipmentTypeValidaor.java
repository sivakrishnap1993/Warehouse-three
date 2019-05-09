package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.ShipmentType;

@Component
public class ShipmentTypeValidaor implements Validator {

	public boolean supports(Class<?> clazz) {
		return ShipmentType.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		ShipmentType st = (ShipmentType) target;

		/*** Drop-Down validation ***/
		if (StringUtils.isEmpty(st.getShipmentMode())) {
			errors.rejectValue("shipmentMode", null, "Please Choose One Value");
		}
		/*** Text Input Validations ***/
		if (!Pattern.matches("[A-Z]{2,6}", st.getShipmentCode())) {
			errors.rejectValue("shipmentCode", null, "Please Enter Minimum 2-6 Characters");
		}
		/*** Drop-Drown ***/
		if (StringUtils.isEmpty(st.getEnableShipment())) {
			errors.rejectValue("enableShipment", null, "Please Choose One Value");
		}
		/** Radio Button **/
		if (StringUtils.isEmpty(st.getShipmentGrade())) {
			errors.rejectValue("shipmentGrade", null, "Please Choose One Value");
		}
		/**** Text-Area ****/
		if (StringUtils.isEmpty(st.getNote()) || st.getNote().length() > 10) {
			errors.rejectValue("note", null, "Please Enter Note(Maximum 10 Chars)");
		}

	}

}
