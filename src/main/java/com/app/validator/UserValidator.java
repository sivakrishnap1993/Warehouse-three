package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.User;
import com.app.service.IUserService;

@Component
public class UserValidator implements Validator {

	@Autowired
	private IUserService userService;

	public boolean supports(Class<?> clazz) {

		return User.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {

		User user = (User)target;


		//check mobile (text) is empty or not
		if (!StringUtils.hasText(user.getUsrName().trim())) {
			errors.rejectValue("usrName", null, "please enter your name !");
		} else if (!Pattern.matches("[a-z \\s	 A-Z]{5,25}", user.getUsrName())) {
			errors.rejectValue("usrName", null, "Name must be 5-25 !");
		}

		//check user type (radio button) is empty or not
		if (StringUtils.isEmpty(user.getGender())) {
			errors.rejectValue("gender", null, "please select choose any one !");
		}

		String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
		//check mail (text) is empty or not
		if (!StringUtils.hasText(user.getUsrMail().trim())) {
			errors.rejectValue("usrMail", null, "please enter your email !");
		} else if (!Pattern.matches(EMAIL_REGEX, user.getUsrMail())) {
			errors.rejectValue("usrMail", null, "please enter valid email !");
		} else if (userService.isEmailOrMobileExist("usrMail", user.getUsrMail())) {
			errors.rejectValue("usrMail", null, "email already exist !");
		}

		String MOBILE_REGEX = "[6-9]{1}[\\d]{9}";
		//check mobile (text) is empty or not
		if (!StringUtils.hasText(user.getUserMobile().trim())) {
			errors.rejectValue("userMobile", null, "please enter your mobile number !");
		} else if (!Pattern.matches(MOBILE_REGEX, user.getUserMobile())) {
			errors.rejectValue("userMobile", null, "please enter valid number !");
		} else if (userService.isEmailOrMobileExist("userMobile", user.getUserMobile())) {
			errors.rejectValue("userMobile", null, "mobile number already exist !");
		}

		//check mail (text) is empty or not
		if (!StringUtils.hasText(user.getUsrPwd().trim())) {
			errors.rejectValue("usrPwd", null, "please enter password !");
		} else if (!Pattern.matches("[a-zA-Z0-9]{6,8}", user.getUsrPwd())) {
			errors.rejectValue("usrPwd", null, "password must be 6-8 chars !");
		}

		//checking list is empty
		if (user.getUsrRoles().isEmpty()||user.getUsrRoles()==null) {
			errors.rejectValue("usrRoles", null, "please select atleast one or more!");
		}
	}


}
