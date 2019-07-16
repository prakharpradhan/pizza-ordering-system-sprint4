 package com.cg.pos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.pos.dto.CustomerDetails;
import com.cg.pos.exceptions.PizzaException;
import com.cg.pos.service.CustomerService;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

	CustomerDetails details;

	@Autowired
	CustomerService service;

	public void setService(CustomerService service) {
		this.service = service;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public CustomerDetails getCustomerDetails(@PathVariable("id") String id) {
		CustomerDetails customerDetails = new CustomerDetails();
		customerDetails.setCustomerId(id);

		int flag = 0;
		try {

			details = service.ViewCustomer(customerDetails);

		} catch (PizzaException e) {
			// TODO Auto-generated catch block
			flag = 1;
			e.printStackTrace();
		}
		if (flag == 0)
			return details;
		else
			return null;
	}
}
