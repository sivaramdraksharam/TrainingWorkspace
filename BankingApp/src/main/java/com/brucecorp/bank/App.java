package com.brucecorp.bank;

import java.util.ArrayList;
import java.util.List;

import com.brucecorp.bank.constants.TransferType;
import com.brucecorp.bank.model.Account;
import com.brucecorp.bank.model.Customer;
import com.brucecorp.bank.model.SavingsAccount;
import com.brucecorp.bank.service.TransactionService;

/**
 * Hello world!
 * 
 */
public class App {
	private static List<Account> accouList = new ArrayList<Account>();

	public static void loadData() {
		Customer cust1 = new Customer(10001, "Clark Kent");
		Customer cust2 = new Customer(10001, "Lois Lane");
		Customer cust3 = new Customer(10001, "Barry Allen");

		Account acc1 = new SavingsAccount("ACC01", cust1, 5000, 6);
		Account acc2 = new SavingsAccount("ACC02", cust2, 5000, 6);
		Account acc3 = new SavingsAccount("ACC03", cust3, 5000, 6);

		accouList.add(acc1);
		accouList.add(acc2);
		accouList.add(acc3);

	}

	public static void main(String[] args) {
		System.out.println("Hello World!");
		loadData();

		// Clark DEbit 3000 from account
		TransactionService.getInstance().withDrawcash(TransferType.DEBIT,
				accouList.get(0), 3000);

		// Clark Transfer 3000 to Lois
		TransactionService.getInstance().makeTranasction(accouList.get(0),
				accouList.get(1), 3000);

		System.out.println("clark Balance:"
				+ accouList.get(0).getAccountBalance());
	}
}
