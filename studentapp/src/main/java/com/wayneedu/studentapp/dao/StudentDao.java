package com.wayneedu.studentapp.dao;

import java.util.Map;

import com.wayneedu.studentapp.DataStore;
import com.wayneedu.studentapp.model.Student;

public class StudentDao {
	private static final StudentDao instance = new StudentDao();

	private StudentDao() {
	}

	public static StudentDao getInstance() {
		return instance;
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
