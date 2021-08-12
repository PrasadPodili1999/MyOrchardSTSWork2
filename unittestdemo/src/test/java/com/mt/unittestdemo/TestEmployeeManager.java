package com.mt.unittestdemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mt.unittestdemo.dao.EmployeeDao;
import com.mt.unittestdemo.model.Employee;
import com.mt.unittestdemo.service.EmployeeManager;

public class TestEmployeeManager {

	@InjectMocks
	EmployeeManager manager;
	
	@Mock
	EmployeeDao dao;
	
	@BeforeEach
	public void init()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getAllEmployeeTest()
	{
		List<Employee> list=new ArrayList<Employee>();
		
		list.add(new Employee(1, "john", "smith", "john.smith@gmail.com"));
		list.add(new Employee(2, "raj", "varma", "raj.cena@gmail.com"));
		list.add(new Employee(3, "pratik", "singh", "prattt.varma@gmail.com"));
		
		when(dao.getEmployeeList()).thenReturn(list);
		
		//test
		List<Employee> empList=manager.getAllEmployee();
		
		assertEquals(3, empList.size());
		verify(dao,times(1)).getEmployeeList();
	}
	
	@Test
	public void getEmployeeByIdTest()
	{
		when(dao.getEmployeeById(1)).thenReturn(new Employee(1, "john", "smith", "john.smith@gmail.com"));
		
		Employee emp=manager.getEmployeeById(1);
		assertEquals("john", emp.getFirstName());
		assertEquals("smith", emp.getLastName());
		assertEquals("john.smith@gmail.com", emp.getEmail());
	}
	
	@Test
	public void createEmployeeTest()
	{
		Employee emp=new Employee(1,"adam","gilchrist","australia@gmail.com");
		manager.addEmployee(emp);
		verify(dao,times(1)).addEmployee(emp);
	}
	
	@Test
	public void updateEmployeeTest()
	{
		Employee emp=new Employee(1,"adam","gilchrist","australia@gmail.com");
		manager.updateEmployee(emp);
		verify(dao,times(1)).updateEmployee(emp);
	}
	
	@Test
	public void deleteEmployeeByIdTest()
	{
		when(dao.deleteEmployeeById(1)).thenReturn("deleted successfully");
		manager.deleteEmployeeById(1);
		verify(dao,times(1)).deleteEmployeeById(1);
	}
}
