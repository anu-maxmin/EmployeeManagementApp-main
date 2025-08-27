package com.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String department;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(Long id, String name, String email, String phone, String department) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.department = department;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	
}
