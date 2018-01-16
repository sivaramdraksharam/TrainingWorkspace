package com.brucecorp.bank.model;

import com.brucecorp.bank.constants.AccountType;

public class CCAccount extends Account{

	private double overDraftLimit;

	public CCAccount(String accountNo,double accountBalance,double overDraftLimit) {
		super(accountNo, accountBalance);
		this.overDraftLimit = overDraftLimit;
	}
	
	public double getOverDraftLimit() {
		return overDraftLimit;
	}

	public void setOverDraftLimit(double overDraftLimit) {
		this.overDraftLimit = overDraftLimit;
	}

	@Override
	public synchronized void makeWithdrawl(double amount) {
		double availBalance = accountBalance - amount;
		if(availBalance+overDraftLimit < 0){
			System.out.println("Exceeds Overdraft limit.Declining transaction");
		}else{
			accountBalance = accountBalance - amount;
		}
			
		
	}

	@Override
	public AccountType getAccountType() {
		return AccountType.CC_ACCOUNT;
	}
	
}
