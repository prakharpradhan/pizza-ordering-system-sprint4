package com.cg.pos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.pos.dto.CartDetails;
import com.cg.pos.dto.OrderDetails;
import com.cg.pos.exceptions.PizzaException;
import com.cg.pos.service.CartService;

@RestController
@RequestMapping(value = "/cart")
public class CartController {
	@Autowired
	private CartService cart;

	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET, produces = "application/json")
	public CartDetails getCartDetails(@PathVariable("id") int id) {
		CartDetails cartDetails = new CartDetails();

		int flag = 0;
		try {
			cartDetails = cart.viewCart(id);
		} catch (PizzaException e) {
			flag = 1;
			e.printStackTrace();
		}
		if (flag == 0)
			return cartDetails;
		else
			return null;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public String deleteCartDetails(@PathVariable("id") int id) {

		int flag = 0;
		try {
			cart.deleteCart(id);
		} catch (PizzaException e) {
			flag = 1;
			e.printStackTrace();
		}
		if (flag == 0)
			return "Success";
		else
			return null;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json")
	public String updateCartDetails(@RequestParam("cartId") int cartId, @RequestParam("quantity") int quantity) {

		int flag = 0;
		try {
			cart.addMore(cartId, quantity);
		} catch (PizzaException e) {
			flag = 1;
			e.printStackTrace();
		}
		if (flag == 0)
			return "Success";
		else
			return null;
	}

	@RequestMapping(value = "/add/{storeName}", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public int addCartDetails(@RequestBody CartDetails cartData, @PathVariable("storeName") String name) {

		int flag = 0;
		int cartId=0;
		try {
			 cartId= cart.addToCart(cartData, name);
		} catch (PizzaException e) {
			flag = 1;
			e.printStackTrace();
		}
		if (flag == 0)
			return cartId;
		else
			return 0;
	}

	@RequestMapping(value = "/order", method = RequestMethod.POST, produces = "application/json", consumes= "application/json")
	public int addOrderDetails(@RequestBody OrderDetails order)  {
		int flag = 0;
		int orderId=0;
		try {
		 orderId=cart.confirmOrder( order) ;
		} catch (PizzaException e) {
			flag = 1;
			e.printStackTrace();
		}
		if (flag == 0)
			return orderId;
		else
			return 0;
	}

}
