package com.wayneedu.studentapp.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

import com.wayneedu.studentapp.exceptions.InvalidStudentInputException;
import com.wayneedu.studentapp.model.Student;
import com.wayneedu.studentapp.service.StudentService;
import com.wayneedu.studentapp.sort.StudentSortByAge;
import com.wayneedu.studentapp.sort.StudentSortByMark;
import com.wayneedu.studentapp.sort.StudentSortByName;

public class StudentController {
	private static final StudentController instance = new StudentController();

	private StudentController() {
	}

	public static StudentController getInstance() {
		return instance;
	}

	public void insertStudent(String name, String agestr, String markStr)
			throws InvalidStudentInputException {
		try {
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			Date dob = dateFormat.parse(agestr);
			double mark = Double.parseDouble(markStr);
			StudentService.getInstance().insertStudent(name, dob, mark);
		} catch (NumberFormatException ex) {
			throw new InvalidStudentInputException("Invalid mark input Provided");
		} catch (ParseException e) {
			throw new InvalidStudentInputException("Invalid DOB input Provided");
		}
	}

	public boolean checkStudentById(String idstr)
			throws InvalidStudentInputException {
		try {
			long id = Long.parseLong(idstr);
			return StudentService.getInstance().checkStudentById(id);
		} catch (NumberFormatException ex) {
			throw new InvalidStudentInputException("Provide a valid input ID:");
		}

	}

	public void updateStudentDetail(String idStr, String name, String dobStr,
			String markStr) throws InvalidStudentInputException {
		try {
			double mark = 0;
			Date dob = null;
			long id = Long.parseLong(idStr);

			if (!markStr.isEmpty())
				mark = Double.parseDouble(markStr);
			if (!dobStr.isEmpty()) {
				DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				dob = dateFormat.parse(dobStr);
			}
			
			if (dob == null && mark == 0 && name.isEmpty()) {
				System.out.println("No change done in Student detail");
			} else {
				StudentService.getInstance().updateStudentDetail(id, name, dob, mark);
				System.out.println("Student detail updated Successfully");
			}
		} catch (NumberFormatException ex) {
			throw new InvalidStudentInputException("Invalid mark input Provided");
		} catch (ParseException e) {
			throw new InvalidStudentInputException("Invalid DOB input Provided");
		}
	}

	public void deleteStudentDetail(String id) {
		StudentService.getInstance().deleteStudentDetail(id);
	}

	public void printAllStudents() {
		StudentService.getInstance().printAllStudent();
	}

	public void sortAndPrintStudent(int option) {
		Comparator<Student> comparator = null;
		
		if (option == 1)
			comparator = new StudentSortByName();
		else if (option == 2) 
			comparator = new StudentSortByMark();
		else if (option == 3) 
			comparator = new StudentSortByAge();
			
			
		StudentService.getInstance().sortAndPrintStudent(comparator);
	}

}
