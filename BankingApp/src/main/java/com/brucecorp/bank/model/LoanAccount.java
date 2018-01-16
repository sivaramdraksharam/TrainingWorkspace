package com.brucecorp.bank.model;

import com.brucecorp.bank.constants.AccountType;
import com.brucecorp.bank.exception.TransactionFailureException;

public class LoanAccount extends Account {

	private double loanDueAmount;
	private double interest;
	private SavingsAccount creditAccount;
	private static final double PENALTY_AMOUNT = 100;

	public LoanAccount(String accountNo,double loanAmount, double interest) {
		super(accountNo, loanAmount);
		this.loanDueAmount = loanAmount;
		this.interest = interest;
	}

	public double getLaonAmount() {
		return loanDueAmount;
	}

	public void setLaonAmount(double laonAmount) {
		this.loanDueAmount = laonAmount;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public SavingsAccount getCreditAccount() {
		return creditAccount;
	}

	public void setCreditAccount(SavingsAccount creditAccount) {
		this.creditAccount = creditAccount;
	}

	public double getPremiumAmount() {
		return accountBalance * interest * 0.08 / 100;
	}

	@Override
	public synchronized void makeWithdrawl(double amount)
			throws TransactionFailureException {

		if (amount <= creditAccount.getAccountBalance()) {
			creditAccount.makeWithdrawl(amount);
			loanDueAmount -= amount;

			System.out.println("Premium Amount of " + amount
					+ " has been debited from Credit account " + accountNo
					+ " by thread:" + Thread.currentThread().getName());
		} else {
			loanDueAmount += PENALTY_AMOUNT;
			throw new TransactionFailureException(
					"Insufficient Balance in Account");
		}
	}

	@Override
	public AccountType getAccountType() {
		return AccountType.LOAN_ACCOUNT;
	}

}
