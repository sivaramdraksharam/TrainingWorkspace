package com.brucecorp.bank.model;

public abstract class Account {
	private String accountNo;
	private Customer accountHolder;
	protected double accountBalance;  

	
	
	public Account(String accountNo, Customer accountHolder,
			double accountBalance) {
		super();
		this.accountNo = accountNo;
		this.accountHolder = accountHolder;
		this.accountBalance = accountBalance;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public Customer getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(Customer accountHolder) {
		this.accountHolder = accountHolder;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	public abstract  void makeWithdrawl(double amount);
/*	public synchronized void makeWithdrawl(double amount){
		if(amount<= accountBalance){
			accountBalance = accountBalance -amount; 
		}else{
			System.out.println("Error: Insufficient Balance in Account ");
		}
	}*/
	
	public void makeDeposit(double amount){
		accountBalance +=amount;
	}

}
