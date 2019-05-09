package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Item;

@Component
public class ItemValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Item.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Item i = (Item) target;

		/** TEXT FIELD IN VALIDATION **/
		if (!Pattern.matches("[a-zA-Z]{1,6}", i.getItmCode())) {
			errors.rejectValue("itmCode", null, "Please Fill The Text Field");

		}

		/** TEXT FIELD IN VALIDATION **/
		if (StringUtils.isEmpty(i.getItmWidth())) {
			errors.rejectValue("itmWidth", null, "Please Fill TheText Field");
		}
		/** TEXT FIELD IN VALIDATION **/
		if (StringUtils.isEmpty(i.getItemHeight())) {
			errors.rejectValue("itemHeight", null, "Please Fill The Text Field");

		}
		/** TEXT FIELD IN VALIDATION **/
		if (StringUtils.isEmpty(i.getItemLength())) {
			errors.rejectValue("itemLength", null, "Please Fill The Text Field");

		}

		/** TEXT-FIELD **/
		if (StringUtils.isEmpty(i.getBaseCost())) {
			errors.rejectValue("baseCost", null, "Please Fill TheText Field");
		}
		/** DROP-DOWN **/
		if (StringUtils.isEmpty(i.getBaseCurrency())) {
			errors.rejectValue("baseCurrency", null, "Please Select One Value");
		}
		/** TEXT-FIELD **/
		if (StringUtils.isEmpty(i.getNote())) {
			errors.rejectValue("note", null, "Please Fill TheText Field");
		}
	}

}
