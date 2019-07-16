package com.cg.pos.service;

import com.cg.pos.dto.CustomerDetails;
import com.cg.pos.exceptions.PizzaException;

public interface CustomerService {

	CustomerDetails ViewCustomer(CustomerDetails customerDetails) throws PizzaException;

}
