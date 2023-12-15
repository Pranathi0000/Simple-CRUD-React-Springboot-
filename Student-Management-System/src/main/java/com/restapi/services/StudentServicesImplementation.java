package com.restapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.model.Student;
import com.restapi.repo.StudentRepository;

@Service
public class StudentServicesImplementation implements StudentServices {
     
	@Autowired
	private StudentRepository studentRepo;
	
	@Override
	public String upsert(Student student) {
		
		studentRepo.save(student);
		return null;
	}

	@Override
	public Student getById(int rollNum) {
		
		Optional<Student> details=studentRepo.findById(rollNum);
		
		if(details.isPresent())
		{
			return details.get();
		}
		return null;
	}

	@Override
	public List<Student> getAllStudents() {
		
		return studentRepo.findAll();
	}

	@Override
	public String deleteById(int rollNum) {
	    
		if(studentRepo.existsById(rollNum))
		{
			 studentRepo.deleteById(rollNum);
			 return "Student details deleted";
		}
		else
		{
			return "Record not found";
		}
		
	}

}
