package com.mt.onetomanydemo2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mt.onetomanydemo2.model.Employee;
import com.mt.onetomanydemo2.service.EmployeeService;

@RestController
@RequestMapping("/ems")
public class EmployeeController {

	@Autowired
	EmployeeService empService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)
	{
		Employee emp=empService.addEmployee(employee);
		return new ResponseEntity<Employee>(emp,HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id)
	{
		try 
		{
			return ResponseEntity.status(HttpStatus.OK).body(empService.getEmpById(id));
		} 
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getAllEmp()
	{
		List<Employee> empList=empService.getAllEmployee();
		return new ResponseEntity<List<Employee>>(empList,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee)
	{
		Employee emp=empService.editEmployee(employee);
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteEmpById(@PathVariable("id") int id)
	{
		try
		{
			empService.deleteEmpById(id);
			return ResponseEntity.status(HttpStatus.OK).body("deleted Successfully");
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("No Such Employee is there");
		}
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteAllEmp()
	{
		try
		{
			empService.deleteAllEmployee();
			return ResponseEntity.status(HttpStatus.OK).body("deleted Successfully");
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("No Such Employee is there");
		}
	}
}
