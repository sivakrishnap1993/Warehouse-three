package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Uom;

@Component
public class UomValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Uom.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		Uom u = (Uom) target;

		/** DROP-DOWN **/
		if (StringUtils.isEmpty(u.getUonType())) {
			errors.rejectValue("uonType", null, "Please Choose One Value");
		}
		/** Text Input Validations **/
		if (!Pattern.matches("[A-Z]{2,10}", u.getUomCode())) {
			errors.rejectValue("uomCode", null, "Please Enter The Text Field ");
		}
		/*** RADIO-BUTTON ***/
		if (StringUtils.isEmpty(u.getUomEnable())) {
			errors.rejectValue("uomEnable", null, "Please Enter One Radio Button");
		}
		/** TEXT INPUT VALIDATION **/
		if (StringUtils.isEmpty(u.getMetaCode())) {
			errors.rejectValue("metaCode", null, "Please Fill The Text Filed");
		}
		/** RADIO-BUTTON **/
		if (StringUtils.isEmpty(u.getAdjst())) {
			errors.rejectValue("adjst", null, "Please Choose One Radio Button");
		}
		/** TEXT-AREA **/
		if (StringUtils.isEmpty(u.getNote()) || u.getNote().length() > 10) {
			errors.rejectValue("note", null, "Please Enter Fescription (Max 2-6 Chars)");
		}

	}

}
