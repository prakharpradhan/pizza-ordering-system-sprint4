package com.cg.pos.dao;

import com.cg.pos.dto.CustomerDetails;
import com.cg.pos.exceptions.PizzaException;

public interface CustomerDao {

	CustomerDetails viewCustomerDetails(CustomerDetails customerDetails) throws PizzaException;

}
