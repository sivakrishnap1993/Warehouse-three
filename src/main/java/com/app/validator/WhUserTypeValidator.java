package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.WhUserType;

@Component
public class WhUserTypeValidator implements Validator {

	
	public boolean supports(Class<?> clazz) {
		return WhUserType.class.equals(clazz);
	}

	
	public void validate(Object target, Errors errors) {
		WhUserType w = (WhUserType) target;
		/** RADIO-BUTTON **/
		if (StringUtils.isEmpty(w.getUserOneType())) {
			errors.rejectValue("userOneType", null, "please Choose The Radiobutton");
		}
		/** INPUT FIELD VALIDATION **/
		if (!Pattern.matches("[A-Z]{1,10}", w.getUsrCode())) {
			errors.rejectValue("usrCode", null, "Please Choose Text Field");
		}
		/** DROP-DOWN **/
		if (StringUtils.isEmpty(w.getUsrFor())) {
			errors.rejectValue("usrFor", null, "Please Choose At Least One  Value");
		}
		/** Input Filed Validation **/
		if (StringUtils.isEmpty(w.getUsrEmail())) {
			errors.rejectValue("usrEmail", null, "Please Enter The Text Filed");
		}
		/** Input Filed Validation **/
		if (StringUtils.isEmpty(w.getUsrContact())) {
			errors.rejectValue("usrContact", null, "Please Enter The Text Filed");
		}
		/** DROP-DOWN **/
		if (StringUtils.isEmpty(w.getUserType())) {
			errors.rejectValue("userType", null, "Please Enter The One Field");
		}
		/** Input Field Validation **/
		if (StringUtils.isEmpty(w.getUsrNum())) {
			errors.rejectValue("usrNum", null, "Please Enter The Text Filed");
		}
	}

}
