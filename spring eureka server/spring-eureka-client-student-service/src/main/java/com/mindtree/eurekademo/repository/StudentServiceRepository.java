package com.mindtree.eurekademo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.eurekademo.model.Student;

@Repository
public interface StudentServiceRepository extends CrudRepository<Student, Integer>{

}
