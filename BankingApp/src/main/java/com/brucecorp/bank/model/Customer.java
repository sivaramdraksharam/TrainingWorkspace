package com.brucecorp.bank.model;

public class Customer {
	private long userId;
	private String CustomerName;
	
	
	public Customer(long userId, String customerName) {
		super();
		this.userId = userId;
		CustomerName = customerName;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

}
