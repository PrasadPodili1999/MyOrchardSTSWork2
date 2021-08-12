package com.mt.manytomanydemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mt.manytomanydemo.model.Course;
@Repository
public interface CourseRepository extends CrudRepository<Course, Integer>{

}
