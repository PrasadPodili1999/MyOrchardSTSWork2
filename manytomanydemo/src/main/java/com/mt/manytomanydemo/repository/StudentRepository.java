package com.mt.manytomanydemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mt.manytomanydemo.model.Student;
@Repository
public interface StudentRepository extends CrudRepository<Student, Integer>{

}
