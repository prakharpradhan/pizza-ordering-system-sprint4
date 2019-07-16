package com.cg.pos.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * bean class for pizza details
 * 
 * @author prakhar
 *
 */

@Entity
@Table(name = "pizza")
public class PizzaDetails {

	private int storeID;
	private String pizzaName;
	@Id
	private int itemId;
	@Column(name = "quantity")
	private int qty;
	private double price;

	public PizzaDetails(String storeName, int itemId, int qty, double price) {
		super();

		this.itemId = itemId;
		this.qty = qty;
		this.price = price;
	}

	public PizzaDetails() {

	}

	// Getter and Setter to Access private Member

	public String getPizzaName() {
		return pizzaName;
	}

	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}

	public int getStoreID() {
		return storeID;
	}

	public void setStoreID(int storeID) {
		this.storeID = storeID;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "StoreId=" + storeID + "\n ItemId=" + itemId + "\n Qty=" + qty + "\n Price=" + price + "\n"
				+ "PizzaName=" + pizzaName + "\n";
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
