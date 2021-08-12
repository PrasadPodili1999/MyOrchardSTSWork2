package com.mt.manytomanydemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mt.manytomanydemo.model.Course;
import com.mt.manytomanydemo.service.CourseService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	CourseService courseService;
	
	@RequestMapping(value = "/addCourse",method = RequestMethod.POST)
	public ResponseEntity<Course> addCourse(@RequestBody Course course)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(courseService.addCourse(course));
	}
	
	@RequestMapping(value = "/addCourses",method = RequestMethod.POST)
	public ResponseEntity<List<Course>> addCourse(@RequestBody List<Course> courses)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(courseService.addCourse(courses));
	}
	
	@RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
	public ResponseEntity<Optional<Course>> getCourseById(@PathVariable("id") int id) 
	{
		try
		{
			return ResponseEntity.status(HttpStatus.FOUND).body(courseService.getCourseById(id));
		}catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.FOUND).build();
		}
	}
	@RequestMapping(value = "/get",method = RequestMethod.GET)
	public ResponseEntity<List<Course>> getAllCourses()
	{
		return ResponseEntity.status(HttpStatus.FOUND).body(courseService.getAllCourses()); 
	}
	@RequestMapping(value = "/update",method = RequestMethod.PUT)
	public ResponseEntity<Course> updateCourse(@RequestBody Course course)
	{
		return ResponseEntity.status(HttpStatus.OK).body(courseService.updateCourse(course));
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteCourseById(@PathVariable("id") int id)
	{
		try
		{
			courseService.deleteCourseById(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		catch(Exception e)
		{
			log.error("Course was not found "+e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}
		
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteAllCourses()
	{
		try
		{
			courseService.deleteAllCourses();
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		catch(Exception e)
		{
			log.error("Courses was not found "+e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
