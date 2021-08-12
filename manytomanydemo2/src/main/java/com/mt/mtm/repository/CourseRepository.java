package com.mt.mtm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mt.mtm.model.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer>{

	public Course findByName(String courseName);
}
