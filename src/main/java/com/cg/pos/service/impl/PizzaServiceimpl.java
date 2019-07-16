package com.cg.pos.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.pos.dao.PizzaDao;
import com.cg.pos.dto.PizzaDetails;
import com.cg.pos.dto.StoreDetails;
import com.cg.pos.exceptions.PizzaException;
import com.cg.pos.service.PizzaService;;;

/**
 * class to View pizza in a store
 * 
 * @author prakhar
 *
 */
@Service
public class PizzaServiceimpl implements PizzaService {
	@Autowired
	private PizzaDao pizza;

	public void setPizza(PizzaDao pizza) {
		this.pizza = pizza;
	}

	@Override
	/*
	 * method to show pizza details of a store
	 * 
	 */
	public List<PizzaDetails> viewPizza(String store) throws PizzaException {

		System.out.println("service");
		return pizza.getPizzaDetails(store);

	}

	@Override
	public ArrayList<PizzaDetails> modifyName(int id, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PizzaDetails> modifyQuantity(int id, int quantity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PizzaDetails> modifyCost(int id, double cost) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String modifyAddOns(int id, String addOns) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PizzaDetails> deletePizzaDetails(int pizzaId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String add(PizzaDetails pizza) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<StoreDetails> initStore() {
		// TODO Auto-generated method stub
		return null;
	}

}
