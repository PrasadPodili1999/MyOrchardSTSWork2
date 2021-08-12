package com.mt.manytomanydemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mt.manytomanydemo.exceptionhandler.CourseNotFoundException;
import com.mt.manytomanydemo.model.Course;

@Service
public interface CourseService {

	public Course addCourse(Course course);
	public List<Course> addCourse(List<Course> courses);
	public Optional<Course> getCourseById(int id) throws CourseNotFoundException;
	public List<Course> getAllCourses();
	public Course updateCourse(Course course);
	public void deleteCourseById(int id) throws CourseNotFoundException;
	public void deleteAllCourses() throws CourseNotFoundException;
}
