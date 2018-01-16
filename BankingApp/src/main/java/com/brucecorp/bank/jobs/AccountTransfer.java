package com.brucecorp.bank.jobs;

import com.brucecorp.bank.exception.TransactionFailureException;
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
		try {
			sourceAccount.makeWithdrawl(amount);
			beneAccount.makeDeposit(amount);

		} catch (TransactionFailureException e) {
			System.out.println("Thread -" + Thread.currentThread().getName()
					+ "transfer from " + sourceAccount.getAccountNo() + " to "
					+ beneAccount.getAccountNo() + " failed due to "
					+ e.getMessage());
		}

	}

}
