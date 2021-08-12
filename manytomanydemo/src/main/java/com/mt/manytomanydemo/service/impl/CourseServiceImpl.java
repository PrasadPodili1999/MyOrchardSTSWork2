package com.mt.manytomanydemo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mt.manytomanydemo.exceptionhandler.CourseNotFoundException;
import com.mt.manytomanydemo.model.Course;
import com.mt.manytomanydemo.repository.CourseRepository;
import com.mt.manytomanydemo.service.CourseService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	CourseRepository courseRepo;
	
	public Course addCourse(Course course)
	{
		return courseRepo.save(course);
	}
	
	public List<Course> addCourse(List<Course> courses)
	{
		List<Course> courseList=new ArrayList<>();
		Iterable<Course> itr=courseRepo.saveAll(courses);
		for(Course course:itr)
		{
			courseList.add(course);
		}
		return courseList;
	}
	
	public Optional<Course> getCourseById(int id) throws CourseNotFoundException
	{
		Optional<Course> course=courseRepo.findById(id);
		if(course.isEmpty())
		{
			throw new CourseNotFoundException("course with id :"+id+" not available");
		}
		else
		{
			return course;
		}
	}
	
	public List<Course> getAllCourses()
	{
		List<Course> courseList=new ArrayList<>();
		Iterable<Course> itr=courseRepo.findAll();
		for(Course course:itr)
		{
			courseList.add(course);
		}
		return courseList;
	}
	public Course updateCourse(Course course)
	{
		return courseRepo.save(course);
	}
	
	public void deleteCourseById(int id) throws CourseNotFoundException
	{
		Optional<Course> course=getCourseById(id);
		if(course.isPresent())
		{
			courseRepo.deleteById(id);
			log.info("deleted successfully");
		}
		else
		{
			throw new CourseNotFoundException("course with id :"+id+" not available");
		}
	}
	
	public void deleteAllCourses() throws CourseNotFoundException
	{
		List<Course> list=getAllCourses();
		if(list.isEmpty())
		{
			throw new CourseNotFoundException("courses  not available");
		}
		else
		{
			courseRepo.deleteAll();
			log.info("deleted successfully");
		}
	}
}
