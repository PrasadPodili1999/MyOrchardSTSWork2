package com.mt.springdatajpaemp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mt.springdatajpaemp.entity.Address;
import com.mt.springdatajpaemp.entity.Employee;
import com.mt.springdatajpaemp.repository.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	public EmployeeRepository empRepo;
	
	@GetMapping("/employee/{id}")
	public Employee getEmployeeById(@PathVariable("id") int id)
	{
		Employee employee=empRepo.findById(id).get();
		return employee;
	}
	@GetMapping("/employees")
	public List<Employee> getAllEmp()
	{
		List<Employee> empList=new ArrayList<>();
		Iterable<Employee> itr=empRepo.findAll();
		for(Employee e:itr)
		{
			empList.add(e);
		}
		return empList;
	}
	@PostMapping("/employee")
	public Employee createEmployee(@RequestBody Employee employee)
	{
		Address address=new Address();
		address.setId(4);
		address.setCity("bnglr");
		address.setCode(98765);
		address.setEmployee(employee);
		employee.setAddress(address);
		empRepo.save(employee);
		return getEmployeeById(employee.getId());	
	}
	@DeleteMapping("/employee/{id}")
	public List<Employee> deleteEmployee(@PathVariable("id") int id)
	{
		empRepo.deleteById(id);
		System.out.println("deleted successfully");
		return getAllEmp();
	}
}
