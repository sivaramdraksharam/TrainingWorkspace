package com.brucecorp.bank.model;

public class SavingsAccount extends Account{
	
	public SavingsAccount(String accountNo, Customer accountHolder,double accountBalance, double intrest) {
		super(accountNo, accountHolder, accountBalance);
		this.interest = intrest;
	}

	private static final double MIN_BALANCE = 100; 
	
	private double interest;

	public double getIntrest() {
		return interest;
	}

	public void setIntrest(double intrest) {
		this.interest = intrest;
	}

	public static double getMinBalance() {
		return MIN_BALANCE;
	}

	@Override
	public synchronized void makeWithdrawl(double amount) {
		if(amount<= accountBalance){
			double availBalance = accountBalance -amount; 
			
			if(availBalance>MIN_BALANCE)
				accountBalance =  accountBalance -amount; 
		}else{
			System.out.println("Error: Insufficient Balance in Account ");
		}
		
	}
}
