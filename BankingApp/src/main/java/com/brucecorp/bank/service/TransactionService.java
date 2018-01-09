package com.brucecorp.bank.service;

import com.brucecorp.bank.constants.TransferType;
import com.brucecorp.bank.jobs.AccountTransfer;
import com.brucecorp.bank.jobs.CashTransfer;
import com.brucecorp.bank.model.Account;

public class TransactionService {

	private static TransactionService instance;
	
	private TransactionService(){};
	
	public static TransactionService getInstance() {
		if (instance == null) {
			synchronized (TransactionService.class) {
				instance = new TransactionService();
			}
		}
		return instance;
	}

	public void makeTranasction(Account account, Account bene, double amount) {
		AccountTransfer transferTask = new AccountTransfer(account, bene,
				amount);
		Thread thread = new Thread(transferTask);
		thread.start();
	}

	public void withDrawcash(TransferType txnType, Account account,
			double amount) {
		CashTransfer transferTask = new CashTransfer(txnType, amount, account);
		Thread thread = new Thread(transferTask);
		thread.start();
	}

}
