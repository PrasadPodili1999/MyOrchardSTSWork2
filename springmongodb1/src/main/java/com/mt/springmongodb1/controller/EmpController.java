package com.mt.springmongodb1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mt.springmongodb1.model.Employee;
import com.mt.springmongodb1.service.EmpService;

@RestController
public class EmpController {

	@Autowired
	EmpService empService;
	
	@PostMapping("/addEmployee")
	public Employee insertEmployee(@RequestBody Employee emp)
	{
		return empService.insertEmployee(emp);
	}
	
	@GetMapping("/getEmployee/{id}")
	public Optional<Employee> getEmployee(@PathVariable("id") int id)
	{
		return empService.getEmployee(id);
	}
	
	@GetMapping("/getEmployee")
	public List<Employee> getAllEmployee()
	{
		return empService.getAllEmployee();
	}
	
	@DeleteMapping("/delete/{id}")
	public List<Employee> deleteEmployeeById(@PathVariable("id") int id)
	{
		empService.deleteEmployeeById(id);
		return getAllEmployee();
	}
}
