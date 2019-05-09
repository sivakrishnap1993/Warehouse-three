package com.app.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Purchase;

@Component
public class PurchaseValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Purchase.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		Purchase p = (Purchase) target;

		/* TEXT-FIELD */
		if (StringUtils.isEmpty(p.getOrdCode())) {
			errors.rejectValue("ordCode", null, "Please Enter Text Field");
		}
		/** DROP-DOWN** shipMode **/
		if (StringUtils.isEmpty(p.getShipMode())) {
			errors.rejectValue("shipMode", null, "Please Select One Value");
		}
		
		/* TEXT-FIELD*refNo **/
		if (StringUtils.isEmpty(p.getRefNo())) {
			errors.rejectValue("refNo", null, "Please Enter the Data In the Field");
		}
		/** RADIO-BUTTON**qtyCk **/
		if (StringUtils.isEmpty(p.getQtyCk())) {
			errors.rejectValue("qtyCk", null, "Please Select One Readio Button");
		}
		/** TEXT-FIELD**ordSts **/
		if (StringUtils.isEmpty(p.getOrdSts())) {
			errors.rejectValue("ordSts", null, "Please Enter the Data In the Field");
		}
		/** TEXT-AREA**node **/
		/**** Text-Area ****/
		if (StringUtils.isEmpty(p.getNode()) || p.getNode().length() > 10) {
			errors.rejectValue("node", null, "Please Enter Note(Maximum 10 Chars)");
		}
	}

}
