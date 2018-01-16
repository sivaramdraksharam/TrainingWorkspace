package com.brucecorp.bank.jobs;

import com.brucecorp.bank.constants.TransferType;
import com.brucecorp.bank.exception.TransactionFailureException;
import com.brucecorp.bank.model.Account;

public class CashTransfer implements Runnable {

	private TransferType txnType;
	private Account sourceAccount;
	private double amount;

	public CashTransfer(TransferType txnType, double amount, Account sourceAccount) {
		super();
		this.txnType = txnType;
		this.amount = amount;
		this.sourceAccount = sourceAccount;
	}

	@Override
	public void run() {
		if(txnType.equals(TransferType.CREDIT)){
			sourceAccount.makeDeposit(amount);
		}else if (txnType.equals(TransferType.DEBIT)) {
			try {
				sourceAccount.makeWithdrawl(amount);
				System.out.println("Run - Cash of Rs."+amount+" Withdrawl from "+sourceAccount.getAccountNo()+" by thread: "+Thread.currentThread().getName());
			} catch (TransactionFailureException e) {
				System.out.println("Thread -"+Thread.currentThread().getName()+" :Cash Withdrawl from "+sourceAccount.getAccountNo() +" failed due to "+e.getMessage());
				
			}
		}
	}

}
