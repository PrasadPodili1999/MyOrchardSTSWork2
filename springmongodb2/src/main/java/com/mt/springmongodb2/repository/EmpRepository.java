package com.mt.springmongodb2.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mt.springmongodb2.model.Employee;

@Repository
public interface EmpRepository extends MongoRepository<Employee, Integer>{

	public Optional<Employee> getEmpByName(String name);
}
