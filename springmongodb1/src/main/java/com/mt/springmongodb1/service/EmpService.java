package com.mt.springmongodb1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mt.springmongodb1.model.Employee;
import com.mt.springmongodb1.repository.EmpRepository;

@Service
public class EmpService {

	@Autowired
	EmpRepository empRepo;
	
	public Employee insertEmployee(Employee emp)
	{
		return empRepo.save(emp); 
	}
	
	public Optional<Employee> getEmployee(int id)
	{
		return empRepo.findById(id);
	}
	
	public List<Employee> getAllEmployee()
	{
		return empRepo.findAll();
	}
	
	public void deleteEmployeeById(int id)
	{
		 empRepo.deleteById(id);
	}
}
