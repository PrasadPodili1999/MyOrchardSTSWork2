package com.mt.mtm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mt.mtm.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer>{

}
