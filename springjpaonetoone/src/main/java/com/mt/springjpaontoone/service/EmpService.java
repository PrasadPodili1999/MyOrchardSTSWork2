package com.mt.springjpaontoone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mt.springjpaonetoone.entities.Employee;
import com.mt.springjpaontoone.dao.EmpRepository;

@Service
public class EmpService {

	@Autowired
   EmpRepository empRepo;
	
	public List<Employee> getAllEmp()
	{
		return this.empRepo.findAll();
	}
	
	public Employee addEmployee(Employee emp)
	{
		return this.empRepo.save(emp);
	}
	
	public Optional<Employee> getEmployeeById(int id)
	{
		return this.empRepo.findById(id);
	}
	
	
	public Employee updateEmployee(Employee emp)
	{
		return this.empRepo.save(emp);
	}
	public void deleteEmployeeById(int id)
	{
		this.empRepo.deleteById(id);
	}
	public void deleteAllEmp()
	{
		this.empRepo.deleteAll();
	}
}

