package com.brucecorp.bank.model;

public class CCAccount extends Account{

	private double overDraftLimit;

	public CCAccount(String accountNo, Customer accountHolder,double accountBalance,double overDraftLimit) {
		super(accountNo, accountHolder, accountBalance);
		this.overDraftLimit = overDraftLimit;
	}
	
	public double getOverDraftLimit() {
		return overDraftLimit;
	}

	public void setOverDraftLimit(double overDraftLimit) {
		this.overDraftLimit = overDraftLimit;
	}

	@Override
	public void makeWithdrawl(double amount) {
		double availBalance = accountBalance - amount;
		if(availBalance+overDraftLimit < 0){
			System.out.println("Exceeds Overdraft limit.Declining transaction");
		}else{
			accountBalance = accountBalance - amount;
		}
			
		
	}
	
}
