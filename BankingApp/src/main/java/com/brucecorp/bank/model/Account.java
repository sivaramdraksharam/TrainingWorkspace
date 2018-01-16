package com.brucecorp.bank.model;

import com.brucecorp.bank.constants.AccountType;
import com.brucecorp.bank.exception.TransactionFailureException;

public abstract class Account {

	protected String accountNo;
	protected double accountBalance;

	public Account(String accountNo, double accountBalance) {
		super();
		this.accountNo = accountNo;
		this.accountBalance = accountBalance;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public synchronized double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public abstract void makeWithdrawl(double amount)
			throws TransactionFailureException;

	public synchronized void makeDeposit(double amount) {
		System.out.println("Cash of Rs." + amount
				+ " credited in the "+accountNo +"account by thread:"
				+ Thread.currentThread().getName());
		accountBalance += amount;
	}
	
	public abstract AccountType  getAccountType();

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", accountBalance="
				+ accountBalance + "]";
	}

}
