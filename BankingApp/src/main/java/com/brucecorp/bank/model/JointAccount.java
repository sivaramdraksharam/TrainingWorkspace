package com.brucecorp.bank.model;

import java.util.List;

public class JointAccount extends Account {

	public JointAccount(String accountNo, Customer accountHolder,double accountBalance) {
		super(accountNo, accountHolder, accountBalance);
		// TODO Auto-generated constructor stub
	}

	private static final double MIN_BALANCE = 250;
	
	private List<Customer> otherNominee;

	public List<Customer> getOtherNominee() {
		return otherNominee;
	}

	public void setOtherNominee(List<Customer> otherNominee) {
		this.otherNominee = otherNominee;
	}

	public static double getMinBalance() {
		return MIN_BALANCE;
	}

	@Override
	public void makeWithdrawl(double amount) {
		if (amount <= accountBalance) {
			double availBalance = accountBalance - amount;

			if (availBalance > MIN_BALANCE)
				accountBalance = accountBalance - amount;
		} else {
			System.out.println("Error: Insufficient Balance in Account ");
		}

	}

}
