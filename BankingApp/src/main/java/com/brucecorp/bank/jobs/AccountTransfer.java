package com.brucecorp.bank.jobs;

import com.brucecorp.bank.model.Account;

public class AccountTransfer implements Runnable {

	private Account sourceAccount;
	private Account beneAccount;
	private double amount;

	public AccountTransfer(Account sourceAccount, Account beneAccount,
			double amount) {
		super();
		this.sourceAccount = sourceAccount;
		this.beneAccount = beneAccount;
		this.amount = amount;
	}

	@Override
	public void run() {
		// withdraw from the source Account
		sourceAccount.makeWithdrawl(amount);

		// deposit to the source account
		beneAccount.makeDeposit(amount);
	}

}
