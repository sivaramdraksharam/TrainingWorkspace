package com.wayneedu.studentapp.sort;

import java.util.Comparator;

import com.wayneedu.studentapp.model.Student;

public class StudentSortByAge implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
/*		Student s1 = ((Student)o1);
		Student s2 = ((Student)o2);
		int resp = (s1.getAge() - s2.getAge() == 0 ) ? 
		((Student)o1).getAge() - ((Student)o2).getAge();*/
		return ((Student)o1).getAge() - ((Student)o2).getAge();
		
	}

}
