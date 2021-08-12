package com.mt.manytomanydemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mt.manytomanydemo.model.StudentCourse;

@Repository
public interface StudentCourseRepository extends CrudRepository<StudentCourse, Integer>{

}
