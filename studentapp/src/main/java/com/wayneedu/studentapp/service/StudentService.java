package com.wayneedu.studentapp.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.wayneedu.studentapp.DataStore;
import com.wayneedu.studentapp.dao.StudentDao;
import com.wayneedu.studentapp.model.Student;

public class StudentService {

	private static final StudentService instance = new StudentService();

	private StudentService(){}
	
	public static StudentService getInstance(){
		return instance;
	}
	
	public  boolean insertStudent(String name, Date dob, double mark) {
		Student student = new Student(name, dob, mark);
		StudentDao.addStudent(student);
		return true;
	}

	public boolean checkStudentById(long id) {
		Student student = StudentDao.getStudentById(id);
		return (student!=null);
	}

	public void updateStudentDetail(long id, String name, Date dob, double mark) throws ParseException {
		Student student = StudentDao.getStudentById(id);
		if(!name.isEmpty())
			student.setName(name);
		if(dob!=null)
			student.setAge(dob);
		if(mark!=0)
			student.setMark(mark);
		
		
	}

	public void deleteStudentDetail(String id) {
		DataStore.deleteStudentDetail(id);
	}

	public void printAllStudent() {
		Map<Long,Student> studentList = DataStore.getAllStudent();
		Set<Map.Entry<Long, Student>> entrySet = studentList.entrySet();
		for(Map.Entry<Long, Student> enrty : entrySet){
			Student obj = enrty.getValue();
			System.out.println(obj);
		}
	}

	public void sortAndPrintStudent(Comparator<Student> comparator) {
		Collection<Student> studentList = DataStore.getAllStudent().values();
		
		List<Student> sortedList = new ArrayList<>(studentList);
		Collections.sort(sortedList, comparator);		
		for (Object object : sortedList) {
			System.out.println(object);
		}
		
	}

}
