package com.cg.pos.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * bean class for Customer
 * 
 * @author Prakhar
 *
 */
@Entity
@Table(name = "customer")
public class CustomerDetails {
	@Id
	@Column(name = "cid")
	private String customerId;
	@Column(name = "cname")
	private String customerName;
	@Column(name = "contact")

	private String contactNo;
	@Column(name = "gender")
	private String gender;
	@Column(name = "email")
	private String email;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String custId) {
		this.customerId = custId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "CustomerDetails [customerId=" + customerId + ", customerName=" + customerName + ", contactNo="
				+ contactNo + ", gender=" + gender + ", email=" + email + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
