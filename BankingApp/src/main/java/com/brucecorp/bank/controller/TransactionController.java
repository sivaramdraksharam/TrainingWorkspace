package com.brucecorp.bank.controller;

import com.brucecorp.bank.BankDatabase;
import com.brucecorp.bank.constants.TransferType;
import com.brucecorp.bank.model.Account;
import com.brucecorp.bank.model.Customer;
import com.brucecorp.bank.service.TransactionService;

public class TransactionController {
	private static TransactionController instance;
	private TransactionService service;

	private TransactionController() {
		service = TransactionService.getInstance();
	};

	public static TransactionController getInstance() {
		if (instance == null) {
			synchronized (TransactionController.class) {
				instance = new TransactionController();
			}
		}
		return instance;
	}
	
	
	public void initiateInterestDepoit(){
		service.initiateInterestDepoit();
	}
	
	public void initiateLoanCollection(){
		service.initiateLoanCollection();
	}
	
	
	public void accountTransaction(Account account,String beneAccountNo, double amount){
		Account bene = BankDatabase.getAccountByid(beneAccountNo); 
		service.accountTranasction(account, bene, amount);
	}
	
	public void cashTransaction(TransferType txnType,String beneAccountNo, double amount){
		Account account = BankDatabase.getAccountByid(beneAccountNo);
		service.cashTransaction(txnType, account, amount);
	}

	public String getAccountBalance(Customer customer) {
		return service.getAccountBalance(customer);
		
	}
	
	
	
	
	
	

}
