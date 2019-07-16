package com.cg.pos.service;

import com.cg.pos.dto.CartDetails;
import com.cg.pos.dto.OrderDetails;
import com.cg.pos.exceptions.PizzaException;

public interface CartService {
	/*
	 * Cart Service Method
	 */
	public int addToCart(CartDetails cartDetails,String storeName) throws PizzaException;

	public int confirmOrder(OrderDetails details) throws PizzaException;

	public void addMore(int id, int qty) throws PizzaException;

	public CartDetails viewCart(int cartId) throws PizzaException;

	public void deleteCart(int cartId) throws PizzaException;

}
