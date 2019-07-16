package com.cg.pos.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.pos.dto.PizzaDetails;
import com.cg.pos.dto.StoreDetails;
import com.cg.pos.exceptions.PizzaException;

/**
 * Dao class to fetch PIZZA DETAILS according to his storeid
 * 
 * @author PRAKHAR
 *
 */
@Transactional
@Repository

public class PizzaDaoImpl implements PizzaDao {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<PizzaDetails> getPizzaDetails(String store) throws PizzaException {
		List<PizzaDetails> pizzaList = new ArrayList<PizzaDetails>();
		StoreDetails details = new StoreDetails();
		TypedQuery<StoreDetails> query = manager
				.createQuery("select s from StoreDetails s  where s.storeName=:storeName", StoreDetails.class);
		query.setParameter("storeName", store);
		details = query.getSingleResult();
		TypedQuery<PizzaDetails> q = manager.createQuery("select p from PizzaDetails p  where p.storeID=:storeId",
				PizzaDetails.class);
		q.setParameter("storeId", details.getStoreId());
		pizzaList = q.getResultList();
		return pizzaList;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

}
