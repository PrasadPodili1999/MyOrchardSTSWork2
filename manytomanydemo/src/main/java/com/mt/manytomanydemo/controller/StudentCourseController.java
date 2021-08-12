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
import com.mt.manytomanydemo.model.StudentCourse;
import com.mt.manytomanydemo.service.CourseService;
import com.mt.manytomanydemo.service.StudentCourseService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/studentcourse")
public class StudentCourseController {

	@Autowired
	StudentCourseService studentCourseService;
	
	@RequestMapping(value = "/addsc",method = RequestMethod.POST)
	public ResponseEntity<StudentCourse> addStudentCourse(@RequestBody StudentCourse studentCourse)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(studentCourseService.addStudentCourse(studentCourse));
	}
	
	@RequestMapping(value = "/addscs",method = RequestMethod.POST)
	public ResponseEntity<List<StudentCourse>> addStudentCourse(@RequestBody List<StudentCourse> studentCourses)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(studentCourseService.addStudentCourse(studentCourses));
	}
	
	@RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
	public ResponseEntity<Optional<StudentCourse>> getStudentCourseById(@PathVariable("id") int id) 
	{
		try
		{
			return ResponseEntity.status(HttpStatus.FOUND).body(studentCourseService.getStudentCourseById(id));
		}catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.FOUND).build();
		}
	}
	@RequestMapping(value = "/get",method = RequestMethod.GET)
	public ResponseEntity<List<StudentCourse>> getAllStudentCourses()
	{
		return ResponseEntity.status(HttpStatus.FOUND).body(studentCourseService.getAllStudentCourses()); 
	}
	@RequestMapping(value = "/update",method = RequestMethod.PUT)
	public ResponseEntity<StudentCourse> updateStudentCourse(@RequestBody StudentCourse studentCourse)
	{
		return ResponseEntity.status(HttpStatus.OK).body(studentCourseService.updateStudentCourse(studentCourse));
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteStudentCourseById(@PathVariable("id") int id)
	{
		try
		{
			studentCourseService.deleteStudentCourseById(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		catch(Exception e)
		{
			log.error("StudentCourse was not found "+e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}
		
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteAllStudentCourses()
	{
		try
		{
			studentCourseService.deleteAllStudentCourses();
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		catch(Exception e)
		{
			log.error("StudentCourses was not found "+e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
