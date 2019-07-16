package com.cg.pos.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.pos.dto.StoreDetails;
import com.cg.pos.exceptions.PizzaException;

/**
 * Dao class to fetch store name according to his user input
 * 
 * @author PRAKHAR
 *
 */
@Repository
@Transactional
public class StoreDaoImpl implements StoreDao {
	@PersistenceContext
	private EntityManager manager;

	@Override
	public StoreDetails searchStore(StoreDetails store) throws PizzaException {

		StoreDetails stores = new StoreDetails();

		TypedQuery<StoreDetails> query = manager
				.createQuery("select  d from StoreDetails d where d.storeName=:storeName", StoreDetails.class);
		query.setParameter("storeName", store.getStoreName());
		stores = query.getSingleResult();
		return stores;

	}

}
