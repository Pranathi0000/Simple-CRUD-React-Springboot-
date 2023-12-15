package com.restapi.services;

import java.util.List;

import com.restapi.model.Student;

public interface StudentServices {
	
	public String upsert(Student student);
	
	public Student getById(int rollNum);
	
	public List<Student> getAllStudents();
	
	public String deleteById(int rollNum);

}
