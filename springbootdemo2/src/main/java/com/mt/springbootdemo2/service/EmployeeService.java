package com.mt.springbootdemo2.service;

import java.util.List;

import com.mt.springbootdemo2.model.Employee;

public interface EmployeeService {
	 
    public Employee createEmployee(Employee emp);
    public Employee updateEmployee(Employee emp);
    public Employee getEmployee(Long empId);
    public void deleteEmployee(Long empId);
    public List<Employee> getAllEmployee();
}
