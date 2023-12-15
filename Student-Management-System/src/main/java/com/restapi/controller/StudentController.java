package com.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.model.Student;
import com.restapi.services.StudentServices;

@RestController
public class StudentController {
	
	@Autowired
	private StudentServices studentService;
	
	@GetMapping("/studentdetails")
	public ResponseEntity<List<Student>> getAllStudentDetails()
	{
		List<Student> list=studentService.getAllStudents();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@GetMapping("/studentdetails/{rollNum}")
	public ResponseEntity<Student> getStudentById(@PathVariable int rollNum)
	{
		Student student=studentService.getById(rollNum);
		return new ResponseEntity<>(student,HttpStatus.OK);
	}
    
	@PostMapping("/insertdetails")
	public ResponseEntity<String> insertStudentDetails(@RequestBody Student student)
	{
		String status=studentService.upsert(student);
		return new ResponseEntity<>(status,HttpStatus.CREATED);
	}
	
	@PutMapping("/updatedetails")
	public ResponseEntity<String> updateStudentDetails(@RequestBody Student student)
	{
		String status=studentService.upsert(student);
		return new ResponseEntity<>(status,HttpStatus.OK);
	}
	
	@DeleteMapping("/deletedetails/{rollNum}")
	public ResponseEntity<String> deleteStudentDetails(@PathVariable int rollNum)
	{
		String status=studentService.deleteById(rollNum);
		return new ResponseEntity<String>(status,HttpStatus.OK);
	}
}
