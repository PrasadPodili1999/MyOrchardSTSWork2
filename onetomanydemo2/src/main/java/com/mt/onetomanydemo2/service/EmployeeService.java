package com.mt.onetomanydemo2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mt.onetomanydemo2.exceptionhandler.EmployeeNotFoundExcepion;
import com.mt.onetomanydemo2.model.Employee;

@Service
public interface EmployeeService {

	public Employee addEmployee(Employee emp);
	public List<Employee> getAllEmployee();
	public Employee getEmpById(int id) throws EmployeeNotFoundExcepion;
	public Employee editEmployee(Employee emp);
	public void deleteAllEmployee() throws EmployeeNotFoundExcepion;
	public void deleteEmpById(int id) throws EmployeeNotFoundExcepion;
}
