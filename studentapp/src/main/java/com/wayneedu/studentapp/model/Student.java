package com.wayneedu.studentapp.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Student {
	private long id;
	private String name;
	private Date dob;
	private double mark;
	private static long idCounter = 0;

	public Student(String name, Date age, double mark) {
		super();
		idCounter++;
		this.id = idCounter;
		this.name = name;
		this.dob = age;
		this.mark = mark;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getAge() {
		return dob;
	}

	public void setAge(Date age) {
		this.dob = age;
	}

	public double getMark() {
		return mark;
	}

	public void setMark(double mark) {
		this.mark = mark;
	}

	public static long getLastID() {
		return idCounter;
	}

	@Override
	public String toString() {
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
		DateFormat dateFormat = new SimpleDateFormat();
		String dateStr = dateFormat.format(dob);

		Calendar dobCal = Calendar.getInstance();
		dobCal.setTime(dob);
		int age = 0;
		if (currentMonth > dobCal.get(Calendar.MONTH))
			age = currentYear - dobCal.get(Calendar.YEAR);
		else
			age = currentYear - dobCal.get(Calendar.YEAR) - 1;

		return "Student [id=" + id + ", name=" + name + ", age=" + age
				+ "[DOB:" + dateStr + "]" + ", mark=" + mark + "]";
	}

}
