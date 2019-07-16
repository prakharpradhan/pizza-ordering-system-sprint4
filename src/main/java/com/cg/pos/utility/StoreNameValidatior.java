package com.cg.pos.utility;

import com.cg.pos.exceptions.PizzaException;

public class StoreNameValidatior {
	public boolean isValidStoreName(String storeName) throws PizzaException {
		if ((!storeName.matches("^[a-zA-Z]*$") || storeName.isEmpty())) {
			throw new PizzaException(ExceptionMessage.MESSAGE4);

		} else {
			return true;
		}
	}
}
