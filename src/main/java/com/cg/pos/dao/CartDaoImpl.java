package com.cg.pos.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.pos.dto.CartDetails;
import com.cg.pos.dto.CustomerDetails;
import com.cg.pos.dto.OrderDetails;
import com.cg.pos.dto.PizzaDetails;
import com.cg.pos.exceptions.PizzaException;

/**
 * Cart database access class
 * 
 * @author Prakhar
 *
 */
@Repository
@Transactional

public class CartDaoImpl implements CartDao {
	@PersistenceContext
	private EntityManager manager;

	@Override
	public int addToCart(CartDetails cart) throws PizzaException {

		int item = cart.getItemId();

		PizzaDetails details = manager.find(PizzaDetails.class, item);
		cart.setRestCharges(details.getPrice());
		cart.setDelievryCharges(50);
		cart.setTotal((details.getPrice() + 50) * cart.getQuantity());
		manager.persist(cart);
		int id = cart.getCartId();
		return id;
	}

//	@Override
//	public int checkDb(int itemId, String storeName) throws PizzaException {
//		List<PizzaDetails> pizza = new ArrayList<PizzaDetails>();
//		javax.persistence.Query query = manager.createNamedQuery("getPizza");
//		query.setParameter(1, storeName);
//		pizza = query.getResultList();
//		int result = pizza.get(0).getItemId();
//		return result;
//	}

	@Override
	public CartDetails viewCart(int cartId) throws PizzaException {
		return manager.find(CartDetails.class, cartId);
	}

	@Override
	public int deleteCart(int cartId) throws PizzaException {

		CartDetails details = manager.find(CartDetails.class, cartId);
		if (details == null) {
			return 1;
		}
		manager.remove(details);

		return 0;
	}

	@Override
	public int updateCart(int cartId, int qty) throws PizzaException {

		CartDetails details = manager.find(CartDetails.class, cartId);
		if (details == null) {
			return 0;
		}
		double price = details.getRestCharges();
		details.setRestCharges(price * qty);
		details.setQuantity(qty);
		details.setTotal(details.getDelievryCharges() + details.getRestCharges());
		return 1;
	}

	@Override
	public int addOrder(OrderDetails orderDetails) throws PizzaException {
		CustomerDetails customerDetails = manager.find(CustomerDetails.class, orderDetails.getCustId());
		CartDetails cartDetails = manager.find(CartDetails.class, orderDetails.getCartId());
		if (customerDetails != null && cartDetails != null) {
			manager.persist(orderDetails);
			return orderDetails.getOrderId();

		}
		return 0;

	}

	@Override
	public int checkDb(int itemId, String storeName) throws PizzaException {
		// TODO Auto-generated method stub
		return 0;
	}

}