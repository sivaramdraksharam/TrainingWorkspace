package com.brucecorp.bank.model;

import java.util.List;

public class Bank {
	private List<Account> accouList;
	private Account masterAccount;
	
	public List<Account> getAccouList() {
		return accouList;
	}
	public void setAccouList(List<Account> accouList) {
		this.accouList = accouList;
	}
	public Account getMasterAccount() {
		return masterAccount;
	}
	public void setMasterAccount(Account masterAccount) {
		this.masterAccount = masterAccount;
	}
	
	
}
