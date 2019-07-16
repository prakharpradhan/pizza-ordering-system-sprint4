package com.cg.pos.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.pos.dao.StoreDao;
import com.cg.pos.dto.StoreDetails;
import com.cg.pos.exceptions.PizzaException;
import com.cg.pos.service.StoreService;
import com.cg.pos.utility.ExceptionMessage;

@Service
public class StoreServiceimpl implements StoreService {
	@Autowired
	private StoreDao storedao;

	public void setStoredao(StoreDao storedao) {
		this.storedao = storedao;
	}

	@Override
	public StoreDetails viewStoreDetails(StoreDetails store) throws PizzaException {
		StoreDetails str = new StoreDetails();
		str = storedao.searchStore(store);
		if (str == null) {
			throw new PizzaException(ExceptionMessage.MESSAGE5);
		}

		return str;
	}

	@Override
	public ArrayList<StoreDetails> addStoreDetails(StoreDetails storeDetailEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteStoreDetails(String storeName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String ModifyStoreName(int storeId, String storeNmae) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String ModifyStoreContact(int storeId, String storeContact) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String ModifyStoreAddress(int storeId, String storeAddress) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String ModifyOwnerName(int storeId, String ownerName) {
		// TODO Auto-generated method stub
		return null;
	}

}
