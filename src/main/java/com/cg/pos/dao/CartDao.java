package com.cg.pos.dao;

import com.cg.pos.dto.CartDetails;
import com.cg.pos.dto.OrderDetails;
import com.cg.pos.exceptions.PizzaException;

/**
 * Cart Dao Interface
 * 
 * @author Prakhar
 *
 */
public interface CartDao {

	int addToCart(CartDetails cart) throws PizzaException;

	int checkDb(int itemId, String storeName) throws PizzaException;

	CartDetails viewCart(int cartId) throws PizzaException;

	int deleteCart(int cartId) throws PizzaException;

	int updateCart(int cartId, int qty) throws PizzaException;

	int addOrder(OrderDetails orderDetails) throws PizzaException;

}
