package com.wayneedu.studentapp.model;

public class Student {
	private long id;
	private String name;
	private int age;
	private double mark;
	
	
	public Student(long id, String name, int age, double mark) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getMark() {
		return mark;
	}
	public void setMark(double mark) {
		this.mark = mark;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age
				+ ", mark=" + mark + "]";
	}
	
	
}
