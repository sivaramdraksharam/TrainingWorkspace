package com.brucecorp.bank.model;

import com.brucecorp.bank.constants.AccountType;
import com.brucecorp.bank.exception.TransactionFailureException;

public class SavingsAccount extends Account {

	private static final double MIN_BALANCE = 100;

	private double interest;

	public SavingsAccount(String accountNo, double accountBalance, double intrest) {
		super(accountNo, accountBalance);
		this.interest = intrest;
	}

	public double getIntrest() {
		return interest;
	}

	public void setIntrest(double intrest) {
		this.interest = intrest;
	}

	public static double getMinBalance() {
		return MIN_BALANCE;
	}
	
	public double getInterstAmount(){
		return accountBalance*interest*0.08/100;
	}

	@Override
	public synchronized void makeWithdrawl(double amount) throws TransactionFailureException {
		if (amount <= accountBalance) {
			double availBalance = accountBalance - amount;

			if (availBalance > MIN_BALANCE)
				accountBalance = accountBalance - amount;

			System.out.println(
					"Amount of " + amount + " has been debited from "+accountNo+" by thread:" + Thread.currentThread().getName());
		} else {
			throw new TransactionFailureException("Insufficient Balance in Account");
		}

	}

	@Override
	public AccountType getAccountType() {
		return AccountType.SAVINGS_ACCOUNT;
	}
}
