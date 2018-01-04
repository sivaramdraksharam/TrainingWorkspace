package com.wayneedu.studentapp.controller;

import java.util.Comparator;


import com.wayneedu.studentapp.exceptions.InvalidStudentInputException;
import com.wayneedu.studentapp.model.Student;
import com.wayneedu.studentapp.service.StudentService;
import com.wayneedu.studentapp.sort.StudentSortByAge;
import com.wayneedu.studentapp.sort.StudentSortByMark;
import com.wayneedu.studentapp.sort.StudentSortByName;

public class StudentController {
	private static final StudentController instance = new StudentController();
	private StudentController(){}
	
	public static StudentController getInstance(){
		return instance;
	}

	public void insertStudent(String name, String agestr, String markStr) throws InvalidStudentInputException {
		try{
			
			int age = Integer.parseInt(agestr);
			double mark = Double.parseDouble(markStr);
			StudentService.getInstance().insertStudent(name,age,mark);
		}catch(NumberFormatException ex){
			throw new InvalidStudentInputException("Invalid age or mark input Provided");
		}
	}

	public boolean checkStudentById(String idstr) throws InvalidStudentInputException {
		try{
			long id = Long.parseLong(idstr);
			return StudentService.getInstance().checkStudentById( id);
		}catch(NumberFormatException ex){
			throw new InvalidStudentInputException("Provide a valid input ID:");
		}
				
	}

	public void updateStudentDetail(String idStr,String name, String ageStr, String markStr) throws InvalidStudentInputException {
		try{
			long id = Long.parseLong(idStr);
			int age = Integer.parseInt(ageStr);
			double mark = Double.parseDouble(markStr);
			StudentService.getInstance().updateStudentDetail(id,name,age,mark);
		}catch(NumberFormatException ex){
			throw new InvalidStudentInputException("Invalid age or mark input Provided");
		}
	}

	public void deleteStudentDetail(String id) {	
		StudentService.getInstance().deleteStudentDetail( id);
	}

	public void printAllStudents() {
		StudentService.getInstance().printAllStudent();
	}

	public void sortAndPrintStudent(int option) {
		Comparator<Student> comparator = null;
		if(option ==1){
			comparator = new StudentSortByName();
			StudentService.getInstance().sortAndPrintStudent(comparator);
		}else if(option == 2){
			comparator = new StudentSortByMark();
			StudentService.getInstance().sortAndPrintStudent(comparator);
		}else if(option == 3){
			comparator = new StudentSortByAge();
			StudentService.getInstance().sortAndPrintStudent(comparator);
		}		
	}
	
	
	
}
