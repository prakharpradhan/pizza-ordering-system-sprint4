package com.cg.pos.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.pos.exceptions.PizzaException;

public class CustomerValidator {

	public void IdValidation(String custId) throws PizzaException {
		Pattern pattern = Pattern.compile("[1-9]{1}[0-9]{2}");
		Matcher matcher = pattern.matcher(custId);

		if (!(matcher.find()) || custId.isEmpty()) {

			throw new PizzaException(ExceptionMessage.MESSAGE2);

		}
		
	}

}
