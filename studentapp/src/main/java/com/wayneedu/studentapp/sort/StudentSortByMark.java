package com.wayneedu.studentapp.sort;

import java.util.Comparator;

import com.wayneedu.studentapp.model.Student;

public class StudentSortByMark implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		return (int) (((Student)o1).getMark() - ((Student)o2).getMark());
	}

}
