package com.wayneedu.studentapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

import com.wayneedu.studentapp.exceptions.ApplicationStartException;
import com.wayneedu.studentapp.model.Student;

public class DataStore {
	
	private static LinkedHashMap<Long, Student> studentDetails = new LinkedHashMap<>(8, 0.75f, true);
	private static final String DATA_SOURCE_FILE = "StudentList.csv";
	
	public static void loadData() throws ApplicationStartException{
		ClassLoader loader = new App().getClass().getClassLoader();
		URL url = loader.getResource(DATA_SOURCE_FILE);			
		File file = new File(url.getFile());
		try (BufferedReader br = new BufferedReader(new FileReader(file))){
			String line;int i=0;
			 while((line= br.readLine())!=null ){
				 if(i>0){
				    String[] values = line.split(",");
					 long id = Long.parseLong(values[0]);
					 String name = values[1];
					 int age = Integer.parseInt(values[2]);
					 double mark = Double.parseDouble(values[3]);
					 
					 studentDetails.put(id, new Student(id, name, age, mark));
				 }
				 i++; //Skiping header value
			 }	
			 System.out.println(studentDetails);
		} catch (FileNotFoundException e) {
			throw new ApplicationStartException("Error Starting application. CSV File not found");
		} catch (IOException e) {			
			throw new ApplicationStartException("Error Starting application.Invalid  CSV File");
		}catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationStartException("Error Starting application.");
		}
	}


	public static Map<Long, Student> getAllStudent() {
		return studentDetails;
	}


	public static void addStudent(Student student) {
		studentDetails.put(student.getId(), student);
		
	}


	public static void deleteStudentDetail(String id) {
		studentDetails.remove(Long.parseLong(id)); 
		System.out.println("Student with id :"+id+" removed Successfully from datastore");
	}
	

}
