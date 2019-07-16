package com.cg.pos.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.pos.dto.CustomerDetails;
import com.cg.pos.exceptions.PizzaException;

import com.cg.pos.utility.ExceptionMessage;

/**
 * Dao class to fetch customer name according to his id
 * 
 * @author PRAKHAR
 *
 */
@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {
	/**
	 * method to fetch from dao
	 */
	@PersistenceContext
	private EntityManager manager;

	@Override
	public CustomerDetails viewCustomerDetails(CustomerDetails customerDetails) throws PizzaException {

		//System.out.println("abc " + customerDetails.getCustomerId());
		CustomerDetails customer = manager.find(CustomerDetails.class, customerDetails.getCustomerId());
		if (customer == null) {
			throw new PizzaException(ExceptionMessage.MESSAGE11);
		}

		return customer;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

}