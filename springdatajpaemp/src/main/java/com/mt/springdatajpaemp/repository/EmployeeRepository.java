package com.mt.springdatajpaemp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mt.springdatajpaemp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
