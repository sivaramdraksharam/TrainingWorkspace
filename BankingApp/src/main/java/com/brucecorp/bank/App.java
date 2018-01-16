package com.brucecorp.bank;

import com.brucecorp.bank.controller.TransactionController;
import com.brucecorp.bank.model.Customer;

/**
 * Hello world!
 * 
 */
public class App {
	
	public static void main(String[] args) {
		BankDatabase.initiate();
		
		TransactionController controller = TransactionController.getInstance(); 
		
		//Clark Transfer 3000 to ACC006
		Customer clark = BankDatabase.getCustomerByName("Clark Kent");
		controller.accountTransaction(clark.getAccountList().get(0), "ACC006", 3000);
		
		//Lucius transfer 2500 to ACC006
		Customer lucius = BankDatabase.getCustomerByName("lucius fox");
		controller.accountTransaction(lucius.getAccountList().get(1), "ACC006", 2500);
		
		//Account Balance of Lois lane 
		Customer lane = BankDatabase.getCustomerByName("Louis lane");
		String response = controller.getAccountBalance(lane);
		System.out.println(response); 
		
		//Initiate depositing interest on all Saving account		
		System.out.println("*******Initiating interest depoist to dsaving account at month end ********");
		//controller.initiateInterestDepoit();
		
		
	}
}
