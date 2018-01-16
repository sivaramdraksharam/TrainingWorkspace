package com.brucecorp.bank.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private long userId;
	private String CustomerName;
	private List<Account> accountList;
	private List<String> beneList;

	private static long idCounter = 5000;

	public Customer(String customerName) {
		super();
		this.userId = idCounter++;
		CustomerName = customerName;
		accountList = new ArrayList<Account>();
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

	public List<Account> getAccountList() {
		return accountList;
	}

	public List<String> getBeneList() {
		return beneList;
	}

	public void setBeneList(List<String> beneList) {
		this.beneList = beneList;
	}

	@Override
	public String toString() {
		return "Customer [userId=" + userId + ", CustomerName=" + CustomerName
				+ "]";
	}

}
