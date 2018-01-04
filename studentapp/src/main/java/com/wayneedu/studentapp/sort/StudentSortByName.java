package com.wayneedu.studentapp.sort;

import java.util.Comparator;

import com.wayneedu.studentapp.model.Student;

public class StudentSortByName implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		return ((Student)o1).getName().compareTo(((Student)o2).getName());
	}

}
