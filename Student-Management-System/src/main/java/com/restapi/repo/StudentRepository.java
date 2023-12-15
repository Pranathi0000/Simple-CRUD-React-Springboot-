package com.restapi.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.model.Student;

public interface StudentRepository extends JpaRepository<Student, Serializable>{
	
}