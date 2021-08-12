package com.mt.springmongodb2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mt.springmongodb2.model.Employee;
import com.mt.springmongodb2.service.EmpService;

@RestController
//@RequestMapping("/ems")
public class EmpController {

	@Autowired
	EmpService empService;
	
	@PostMapping("/addEmp")
	public Employee addEmployee(@RequestBody Employee emp)
	{
		return empService.addEmployee(emp);
	}
	
	@GetMapping("/getEmp/{name}")
	public Optional<Employee> getEmpByName(@PathVariable("name") String name)
	{
		return empService.getEmpByName(name);
	}
	
	@GetMapping("/getEmp")
	public List<Employee> getAllEmp()
	{
		return empService.getAllEmp();
	}
}
