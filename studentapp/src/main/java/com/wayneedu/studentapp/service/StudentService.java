package com.wayneedu.studentapp.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.Map.Entry;
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
	
	public  boolean insertStudent(String name, int age, double mark) {
		long newId = StudentDao.getLastStudentId()+1;
		Student student = new Student(newId, name, age, mark);
		StudentDao.addStudent(student);
		return true;
	}

	public boolean checkStudentById(long id) {
		Student student = StudentDao.getStudentById(id);
		return (student!=null);
	}

	public void updateStudentDetail(long id, String name, int age, double mark) {
		Student student = StudentDao.getStudentById(id);
		if(!name.isEmpty())
			student.setName(name);
		if(age!=0)
			student.setAge(age);
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
		/*TreeSet sortedList = new TreeSet(comparator);
		sortedList.addAll(studentList);*/
		
		for (Object object : sortedList) {
			System.out.println(object);
		}
		
	}

}
