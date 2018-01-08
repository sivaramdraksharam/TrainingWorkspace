package com.wayneedu.studentapp.test;

import java.util.Calendar;
import java.util.Scanner;

public class Test {
	
	public static void handleCoice(){
		int choice = 0;
		do{
			Scanner reader = new Scanner(System.in);
			System.out.println("Enter your choice:");
			int cal = Calendar.getInstance().get(Calendar.YEAR);
			System.out.println("Year : "+cal); 
			
			choice = Integer.parseInt(reader.nextLine());
			try{
				switch (choice) {
				case 1:	System.out.println("Case 1");				
						break;
				case 2:	System.out.println("Case 2");				
						break;
				case 3:	System.out.println("Case 3");				
						break;
				case 4:	System.out.println("Case 4");				
						break;
				case 5:	System.out.println("Case 5");	
						int result = 1/0;
						break;
				case 6 : System.out.println("Quiting application");	
						break;
				default:
					System.out.println("Default case - "+choice);
					break;
				}
				
			}catch(Exception e){
				System.out.println("Printing exception");
			}
			
		}while(choice!=6);
		
	}
	
	public static void main(String[] args) {
		handleCoice();
	}
	
	
}
