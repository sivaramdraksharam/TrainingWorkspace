package com.wayneedu.studentapp.sort;

import java.util.Comparator;

import com.wayneedu.studentapp.model.Student;

public class StudentSortByAge implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) { 
		return o1.getAge().compareTo(o2.getAge());
	}

}
