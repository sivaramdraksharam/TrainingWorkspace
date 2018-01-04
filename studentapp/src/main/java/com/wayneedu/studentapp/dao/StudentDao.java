package com.wayneedu.studentapp.dao;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.wayneedu.studentapp.DataStore;
import com.wayneedu.studentapp.model.Student;

public class StudentDao {
	private static final StudentDao instance = new StudentDao();
	
	private StudentDao(){}
	
	public static StudentDao getInstance(){
		return instance;
	}

	public static long getLastStudentId() {
		Map<Long, Student> studentDetails = DataStore.getAllStudent();
		Set<Long> idSet = studentDetails.keySet();
		Object[] idList = idSet.toArray();
		long max = (long) idList[0];
		
		for (int i = 0; i < idList.length; i++) {
			
			if((long)idList[i] > max)
				max = (long) idList[i];
		}
		
		return max;
	}

	public static void addStudent(Student student) {
		DataStore.addStudent(student);
	}

	public static Student getStudentById(long id) {		
		return DataStore.getAllStudent().get(id);
	}

	public static Map<Long, Student> getAllStudent() {
		return DataStore.getAllStudent();
	}
	
	
}
