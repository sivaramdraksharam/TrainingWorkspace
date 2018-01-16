package com.brucecorp.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.brucecorp.bank.model.Account;
import com.brucecorp.bank.model.CCAccount;
import com.brucecorp.bank.model.Customer;
import com.brucecorp.bank.model.LoanAccount;
import com.brucecorp.bank.model.SavingsAccount;

public class BankDatabase {

	private static List<Customer> customerList;
	private static Account bankMainAccount;

	public static void initiate() {

		Account acc1 = new SavingsAccount("ACC001", 5000, 6);
		Account acc2 = new SavingsAccount("ACC002", 3500, 4);
		Account acc3 = new SavingsAccount("ACC003", 4000, 4);
		Account acc4 = new SavingsAccount("ACC004", 5500, 2.5);
		Account acc5 = new SavingsAccount("ACC005", 7500, 6);
		Account acc6 = new SavingsAccount("ACC006", 8000, 6);

		Account acc7 = new CCAccount("RACC004", 5000, 100000);
		Account acc8 = new CCAccount("RACC005", 5000, 50000);

		Account acc9 = new LoanAccount("LACC001", 55000, 9.0);
		((LoanAccount) acc9).setCreditAccount((SavingsAccount) acc3);
		Account acc10 = new LoanAccount("LACC002", 80000, 13);
		((LoanAccount) acc9).setCreditAccount((SavingsAccount) acc6);

		setBankMainAccount(new SavingsAccount("MAIN_ACC", 1000000, 0));

		Customer cust1 = new Customer("Clark Kent");
		cust1.getAccountList().add(acc1);
		cust1.getAccountList().add(acc4);
		cust1.getAccountList().add(acc7);

		Customer cust2 = new Customer("Barry allen");
		cust2.getAccountList().add(acc3);
		cust2.getAccountList().add(acc10);

		Customer cust3 = new Customer("lucius fox");
		cust3.getAccountList().add(acc2);
		cust3.getAccountList().add(acc5);

		Customer cust4 = new Customer("Louis lane");
		cust4.getAccountList().add(acc6);
		cust4.getAccountList().add(acc8);
		cust4.getAccountList().add(acc9);

		customerList = new ArrayList<Customer>();
		customerList.add(cust1);
		customerList.add(cust2);
		customerList.add(cust3);
		customerList.add(cust4);

	}

	public static List<Customer> getCustomerList() {
		return customerList;
	}
	
	public static Customer getCustomerByName(String customerName) {
		Customer cust = null;
		cust = customerList.stream().filter(customer -> customer.getCustomerName().equalsIgnoreCase(customerName))
				.findFirst().get();
		return cust;
	}

	public static Stream<Account> getAccountListStream() {
		return customerList.stream().map(cust -> cust.getAccountList()).flatMap(List::stream);
	}

	public static Account getAccountByid(String accountID) {
		Account account = null;
		account = getAccountListStream().filter(acc -> acc.getAccountNo().equals(accountID)).findFirst().get();
		return account;
	}

	public static <T> List<T> getAccountByGroup(Class<T> clas) { 
		List<T> accountList = getAccountListStream().filter(acc->clas.isInstance(acc) ).map(acc->(T)acc).collect(Collectors.toList()); 
		return accountList;
	}
	

	public static Account getBankMainAccount() {
		return bankMainAccount;
	}

	public static void setBankMainAccount(Account bankMainAccount) {
		BankDatabase.bankMainAccount = bankMainAccount;
	}

}
