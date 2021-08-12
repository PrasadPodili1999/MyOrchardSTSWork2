package com.mt.springmongodb2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mt.springmongodb2.model.Employee;
import com.mt.springmongodb2.repository.EmpRepository;

@Service
public class EmpService {

	@Autowired
	EmpRepository empRepo;
	
	public Employee addEmployee(Employee emp)
	{
		return empRepo.save(emp);
	}
	
	public Optional<Employee> getEmpByName(String name)
	{
		return empRepo.getEmpByName(name);
	}
	
	public List<Employee> getAllEmp()
	{
		return empRepo.findAll();
	}
}
