package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Employee;
import com.project.service.EmployeeService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/employee")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
	}

	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployee();
	}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		Employee employee = employeeService.getEmployeeById(id);
		if(employee==null) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(employee);
	}
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<?> deleteEmployeeById(@PathVariable Long id) {
		try {
			employeeService.deleteEmployeeById(id);
			return new ResponseEntity<>("Employee with id " + id + " is deleted successfully", HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			// TODO: handle exception
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
		Employee updatedEmployee = employeeService.updateEmployee(id, employee);
		
		if(updatedEmployee == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		
		return ResponseEntity.ok(updatedEmployee);
	}
}
