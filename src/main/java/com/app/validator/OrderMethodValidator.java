package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.OrderMethod;

@Component
public class OrderMethodValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return OrderMethod.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		OrderMethod or = (OrderMethod) target;

		/**** RADIO-BUTTON**ordMode **/
		if (StringUtils.isEmpty(or.getOrdMode())) {
			errors.rejectValue("ordMode", null, "Please Enter One Radio Button ");
		}
		/*** Text Input Validations ***/
		if (!Pattern.matches("[A-Z]{2,6}", or.getOrdCode())) {
			errors.rejectValue("ordCode", null, "Please Enter Minimum 2-6 Characters");
		}
		/** DROP-DOWN**ordExType **/
		if (StringUtils.isEmpty(or.getOrdExType())) {
			errors.rejectValue("ordExType", null, "Please Enter one Drop Down Value");
		}
		/** CHECK-BOX**ordAccept**note **/
		if (or.getOrdAccept() == null || or.getOrdAccept().isEmpty()) {
			errors.rejectValue("ordAccept", null, "Please Choose The At Least One Check-Box Value");
		}

		/** TEXT FIELD VALIDATION **/
		if (StringUtils.isEmpty(or.getNote())) {
			errors.rejectValue("note", null, "Please Enter Text Field");
		}
	}

}
