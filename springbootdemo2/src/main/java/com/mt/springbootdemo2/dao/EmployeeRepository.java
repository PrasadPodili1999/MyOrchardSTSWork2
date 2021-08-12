package com.mt.springbootdemo2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mt.springbootdemo2.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
