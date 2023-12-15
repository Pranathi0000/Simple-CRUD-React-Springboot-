package com.restapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Student_information")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int rollNum;
	
	private String name;
	private int cls;
	private float cgpa;
	private double fee;
	
	
	//getter and setter methods
	public int getRollNum() {
		return rollNum;
	}
	public void setRollNum(int rollNum) {
		this.rollNum = rollNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCls() {
		return cls;
	}
	public void setCls(int cls) {
		this.cls = cls;
	}
	public float getCgpa() {
		return cgpa;
	}
	public void setCgpa(float cgpa) {
		this.cgpa = cgpa;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	
	//constructors
	public Student(int rollNum, String name, int cls, float cgpa, double fee) {
		super();
		this.rollNum = rollNum;
		this.name = name;
		this.cls = cls;
		this.cgpa = cgpa;
		this.fee = fee;
	}
	
	public Student() {
		super();
	}
	
	
	
	
	

	
	
	
	
	

}
