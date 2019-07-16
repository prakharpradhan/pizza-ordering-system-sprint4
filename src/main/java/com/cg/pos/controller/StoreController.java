package com.cg.pos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.pos.dto.PizzaDetails;
import com.cg.pos.dto.StoreDetails;
import com.cg.pos.service.PizzaService;
import com.cg.pos.service.StoreService;

@RestController
@RequestMapping(value = "/store")
public class StoreController {
	@Autowired
	StoreService storeService;
	@Autowired
	PizzaService pizzaService;

	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}

	public void setPizzaService(PizzaService pizzaService) {
		this.pizzaService = pizzaService;
	}

	@RequestMapping(value = "/get/{name}", method = RequestMethod.GET, produces = "application/json")
	public StoreDetails showStoreDetails(@PathVariable("name") String name) {
		StoreDetails details = new StoreDetails();
		details.setStoreName(name);
		StoreDetails rslt = new StoreDetails();
		int flag = 0;
		try {
			rslt = storeService.viewStoreDetails(details);
		} catch (Exception e) {
			flag = 1;
		}
		if (flag == 0) {
			return rslt;
		} else
			return null;
	}

	@RequestMapping(value = "/{storeName}", method = RequestMethod.GET, produces = "application/json")
	public List<PizzaDetails> showPizzaDetails(@PathVariable(name = "storeName") String storeName) {

		try {

			return (List<PizzaDetails>) pizzaService.viewPizza(storeName);

		} catch (Exception e) {
		}
		return null;
	}
}
