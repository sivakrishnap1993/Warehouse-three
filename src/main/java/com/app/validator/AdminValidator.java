package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Admin;

@Component
public class AdminValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Admin.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Admin a = (Admin) target;

		/** Text Field Validation**admName **/
		if (!Pattern.matches("[A-Z]{2,6}", a.getAdmName())) {
			errors.rejectValue("admName", null, "Please Enter One Input Field");
		}
		/*** RADIO-BUTTON**admType */
		if (StringUtils.isEmpty(a.getAdmType())) {
			errors.rejectValue("admType", null, "Please Enter One Radio Button");
		}
		/** Input Field Validation *admSalary **/
		if (StringUtils.isEmpty(a.getAdmSalary())) {
			errors.rejectValue("admSalary", null, "Please Enter One Input Field");
		}
		/**** DROP-DOWN*dept */
		if (StringUtils.isEmpty(a.getDept())) {
			errors.rejectValue("dept", null, "Please Enter One Drop-Down Field");
		}
		/** CHECK-BOX**admModes **/
		if (StringUtils.isEmpty(a.getAdmModes())) {
			errors.rejectValue("admModes", null, "Please Enter At Least One Check-Box Field");
		}

	}

}
