package com.cg.pos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.pos.dao.CustomerDao;
import com.cg.pos.dto.CustomerDetails;
import com.cg.pos.exceptions.PizzaException;
import com.cg.pos.service.CustomerService;

/**
 * Customer service class
 * 
 * @author Prakhar
 *
 */
@Service

public class CustomerServiceImpl implements CustomerService {
	/**
	 * fetching customer data
	 * 
	 * @throws SQLException
	 */

	@Autowired
	CustomerDao dao;

	public void setDao(CustomerDao dao) {
		this.dao = dao;
	}

	@Override
	public CustomerDetails ViewCustomer(CustomerDetails customerDetails) throws PizzaException {
		// CustomerValidator customerValidator = new CustomerValidator();
		// customerValidator.IdValidation((customerDetails.getCustomerId()));
		return dao.viewCustomerDetails(customerDetails);

	}

}
