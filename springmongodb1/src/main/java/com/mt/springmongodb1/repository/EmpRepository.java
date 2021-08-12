package com.mt.springmongodb1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mt.springmongodb1.model.Employee;

public interface EmpRepository extends MongoRepository<Employee, Integer>{

}
