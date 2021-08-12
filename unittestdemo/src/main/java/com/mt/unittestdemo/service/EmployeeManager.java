package com.mt.unittestdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mt.unittestdemo.dao.EmployeeDao;
import com.mt.unittestdemo.model.Employee;

@Service
public class EmployeeManager {

	@Autowired
	EmployeeDao empDao;
	
	public List<Employee> getAllEmployee()
	{
		return empDao.getEmployeeList();
	}
	
	public Employee getEmployeeById(int id)
	{
		return empDao.getEmployeeById(id);
	}
	
	public void addEmployee(Employee employee)
	{
		empDao.addEmployee(employee);
	}
	
	public void updateEmployee(Employee employee)
	{
		empDao.updateEmployee(employee);
	}
	
	public String deleteEmployeeById(int id)
	{
		return empDao.deleteEmployeeById(id);
	}
}
