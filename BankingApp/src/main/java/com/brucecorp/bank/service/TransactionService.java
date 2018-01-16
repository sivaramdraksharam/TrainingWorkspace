package com.brucecorp.bank.service;

import java.util.List;

import com.brucecorp.bank.BankDatabase;
import com.brucecorp.bank.constants.TransferType;
import com.brucecorp.bank.jobs.AccountTransfer;
import com.brucecorp.bank.jobs.CashTransfer;
import com.brucecorp.bank.model.Account;
import com.brucecorp.bank.model.Customer;
import com.brucecorp.bank.model.LoanAccount;
import com.brucecorp.bank.model.SavingsAccount;

public class TransactionService {

	private static TransactionService instance;

	private TransactionService() {
	};

	public static TransactionService getInstance() {
		if (instance == null) {
			synchronized (TransactionService.class) {
				instance = new TransactionService();
			}
		}
		return instance;
	}

	public void accountTranasction(Account account, Account bene, double amount) {
		AccountTransfer transferTask = new AccountTransfer(account, bene, amount);
		Thread thread = new Thread(transferTask);
		thread.setName(account.getAccountNo());
		thread.start();
		System.out.println("Thread :" + thread.getName() + " Proceeding account transction.");
	}

	public void cashTransaction(TransferType txnType, Account account, double amount) {

		CashTransfer transferTask = new CashTransfer(txnType, amount, account);
		Thread thread = new Thread(transferTask);
		thread.start();
		System.out.println("Thread :" + thread.getName() + " proceeding withdrawl transction.");
	}

	public void initiateInterestDepoit() {
		Account bankAccount = BankDatabase.getBankMainAccount();
		List<SavingsAccount> savingsAccounts =  BankDatabase.getAccountByGroup(SavingsAccount.class);

		for (SavingsAccount account : savingsAccounts) {
			accountTranasction(bankAccount, account, account.getInterstAmount());
		}

	}

	public void initiateLoanCollection() {
		
		Account bankAccount = BankDatabase.getBankMainAccount();
		List<LoanAccount> loanAccounts = BankDatabase.getAccountByGroup(LoanAccount.class); 		

		for (LoanAccount account : loanAccounts) {
			accountTranasction(account, bankAccount, account.getPremiumAmount());
		}
	}

	public String getAccountBalance(Customer customer) {
		List<Account> accountList = customer.getAccountList();
		StringBuilder strbuilder = new StringBuilder();
		strbuilder.append("<account-balance>").append("\n");
		strbuilder.append("\t<account-holder>").append(customer.getCustomerName()).append("</account-holder>")
				.append("\n");

		for (Account account : accountList) {
			strbuilder.append(
					"\t<account>id-" + account.getAccountNo() + "-bal-" + account.getAccountBalance() + "</account>")
					.append("\n");
		}
		strbuilder.append("</account-balance>");

		return strbuilder.toString();

	}

}
