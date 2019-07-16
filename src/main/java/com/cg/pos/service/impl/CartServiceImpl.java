package com.cg.pos.service.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.pos.dao.CartDao;
import com.cg.pos.dto.CartDetails;
import com.cg.pos.dto.OrderDetails;
import com.cg.pos.exceptions.PizzaException;
import com.cg.pos.service.CartService;
import com.cg.pos.utility.ExceptionMessage;

/**
 * cart service add to cart remove cart and confirm order
 * 
 * @author Prakhar
 *
 */
@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private CartDao cartdao;

	public void setCartDao(CartDao cartDao) {
		this.cartdao = cartDao;
	}

	/*
	 * Method to add Item to Cart
	 * 
	 */
	@Override
	public int addToCart(CartDetails cartDetails, String storeName) throws PizzaException {

		int check = 0;

		// int result = cartdao.checkDb(cartDetails.getItemId(), storeName);
		// if (result == cartDetails.getItemId()) {
		check = cartdao.addToCart(cartDetails);
		if (check == 0)

		{
			throw new PizzaException(ExceptionMessage.Message8);
		}
		return check;
	}

	/**
	 * confirming order
	 * 
	 * @throws SQLException
	 */
	@Override
	public int confirmOrder(OrderDetails orderDetails) throws PizzaException {

		int orderId = cartdao.addOrder(orderDetails);
		if (orderId == 0) {

			throw new PizzaException(ExceptionMessage.MESSAGE12);
		}
		return orderId;
	}

	/**
	 * adding more item to cart
	 * 
	 * @throws SQLException
	 */
	@Override
	public void addMore(int cartId, int qty) throws PizzaException {

		int updateRslt = cartdao.updateCart(cartId, qty);
		if (updateRslt == 0) {
			throw new PizzaException(ExceptionMessage.MESSAGE10);
		}

	}

	/**
	 * Method to view cartdeatils
	 * 
	 * @return
	 * @throws PizzaException
	 * @throws SQLException
	 */
	@Override
	public CartDetails viewCart(int cartId) throws PizzaException {

		CartDetails cartDetails = cartdao.viewCart(cartId);
		if (cartDetails == null) {
			throw new PizzaException(ExceptionMessage.MESSAGE10);
		}
		return cartDetails;
	}

	/**
	 * cart details delete function
	 * 
	 * @throws SQLException
	 */
	@Override
	public void deleteCart(int cartId) throws PizzaException {
		int delRslt = cartdao.deleteCart(cartId);
		if (delRslt == 1) {
			throw new PizzaException(ExceptionMessage.MESSAGE10);
		}

	}

}
