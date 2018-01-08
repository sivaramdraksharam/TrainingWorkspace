package com.wayneedu.studentapp;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.wayneedu.studentapp.controller.StudentController;
import com.wayneedu.studentapp.exceptions.ApplicationStartException;
import com.wayneedu.studentapp.exceptions.InvalidStudentInputException;

/**
 * Student App
 * 
 */
public class App {

	public static void handleChoice() {
		try (Scanner reader = new Scanner(System.in);) {
			int choice = 0;

			do {
				try {
					System.out.println("Enter your choice : ");
					choice = Integer.parseInt(reader.nextLine());
					StudentController studentCtrl = StudentController.getInstance();

					switch (choice) {
					case 1: {
						System.out.print("Enter the name:");
						String name = reader.nextLine();
						System.out.println("Enter the DOB (dd-mm-yyyy):");
						String age = reader.nextLine();
						System.out.println("Enter the mark:");
						String mark = reader.nextLine();
						studentCtrl.insertStudent(name, age, mark);
						System.out.println("Student Added Successfully");
						break;
					}
					case 2: {
						System.out.println("Enter the Student ID:");
						String id = reader.nextLine();
						boolean present = studentCtrl.checkStudentById(id);
						if (present) {
							System.out.println("Enter the name (press enter to skip) :");
							String name = reader.nextLine();
							System.out.println("Enter the age (dd-mm-yyyy):(press enter to skip)");
							String age = reader.nextLine();
							System.out.println("Enter the mark:(press enter to skip)");
							String mark = reader.nextLine();
							studentCtrl.updateStudentDetail(id, name, age, mark);
							break;
						} else {
							System.out.println("No Student ");
							break;
						}
					}
					case 3: {
						System.out.println("Enter the ID to be Removed:");
						String id = reader.nextLine();
						boolean present = studentCtrl.checkStudentById(id);
						if (present) {
							studentCtrl.deleteStudentDetail(id);
							break;
						} else {
							System.out.println("No Student ");
							break;
						}
					}
					case 4: {
						studentCtrl.printAllStudents();
						break;
					}
					case 5: {
						System.out.println("Sort student By:");
						System.out.println("1. Sort by Name");
						System.out.println("2. Sort by Mark");
						System.out.println("3. Sort by Age");
						int option = Integer.parseInt(reader.nextLine());
						if (option <= 3 && option >= 1)
							studentCtrl.sortAndPrintStudent(option);
						else
							System.out.println("Invalid sort choice.");
						break;
					}
					case 6:
						System.out.println("Quiting application");
						break;
					default: {
						System.out
								.println("Invalid Choice. Please select number from the list.");
					}
					}
				} catch (NumberFormatException e) {
					System.out
							.println("Invalid Choice.Please provide a valid number");
				} catch (InputMismatchException e) {
					System.out
							.println("Invalid Choice .Please provide a valid number");
				} catch (InvalidStudentInputException e) {
					System.out.println("Error:" + e.getMessage());
				}

			} while (choice != 6);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Sorry Unable to handle your request.");
		}
	}

	public static void main(String[] args) {
		try {
			DataStore.loadData();
			System.out.println("Select from below Choice");
			System.out.println("1. Add a Student");
			System.out.println("2. Update Student detail:");
			System.out.println("3. Remove a Student");
			System.out.println("4. List all Students");
			System.out.println("5. Sort Students by");
			System.out.println("6. Exit the application");
			handleChoice();
		} catch (ApplicationStartException e1) {
			System.out.println(e1.getMessage());
		}

	}
}
