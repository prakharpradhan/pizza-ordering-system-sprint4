package com.cg.pos.dao;

import java.util.List;

import com.cg.pos.exceptions.PizzaException;

public interface PizzaDao {

	

	List getPizzaDetails(String store) throws PizzaException;

}
