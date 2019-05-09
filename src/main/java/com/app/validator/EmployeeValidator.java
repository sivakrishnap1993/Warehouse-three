package com.app.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Employee;

@Component
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Employee.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Employee ee = (Employee) target;

		/** Text Field **/
		if (StringUtils.isEmpty(ee.getEmpName())) {
			errors.rejectValue("empName", null, "Please Enter TheName");
		}
		/** RADIO-BUTTON **/
		if (StringUtils.isEmpty(ee.getCmpLoc())) {
			errors.rejectValue("cmpLoc", null, "Please Select One Value");
		}
		/** Text Field **/
		if (StringUtils.isEmpty(ee.getEmpPwd())) {
			errors.rejectValue("empPwd", null, "Please Enter TheName");
		}
		/** RADIO-BUTTON **/
		if (StringUtils.isEmpty(ee.getEmpGen())) {
			errors.rejectValue("empGen", null, "Please Select One Value");
		}
		/**** Text-Area ****/
		if (StringUtils.isEmpty(ee.getEmpAddr()) || ee.getEmpAddr().length() > 10) {
			errors.rejectValue("empAddr", null, "Please Enter Note(Maximum 10 Chars)");
		}
	}

}
