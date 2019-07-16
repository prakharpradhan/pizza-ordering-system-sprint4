package com.cg.pos.dao;

import com.cg.pos.dto.StoreDetails;
import com.cg.pos.exceptions.PizzaException;

public interface StoreDao {

	StoreDetails searchStore(StoreDetails store) throws PizzaException;

}
