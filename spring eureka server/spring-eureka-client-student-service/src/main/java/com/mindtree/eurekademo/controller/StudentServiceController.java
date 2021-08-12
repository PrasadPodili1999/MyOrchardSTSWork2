package com.mindtree.eurekademo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.eurekademo.exception.InvalidDataException;
import com.mindtree.eurekademo.exception.StudentNotFoundException;
import com.mindtree.eurekademo.model.Student;
import com.mindtree.eurekademo.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class StudentServiceController {

	@Autowired
	StudentService service;
	
	@RequestMapping(value = "/addStudent",method = RequestMethod.POST)
	public ResponseEntity<Student> addStudent(@RequestBody Student student) throws InvalidDataException
	{
		Student result=service.addStudent(student);
		log.info("student added successfully");
		return new ResponseEntity<Student>(result,HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/getStudentDetailsForSchool/{schoolName}", method = RequestMethod.GET)
	public ResponseEntity<List<Student>> getStudents(@PathVariable("schoolName") String schoolName)
					throws StudentNotFoundException
	{
		log.info("Getting Student details for " + schoolName);
		List<Student> result=service.getStudents(schoolName);
		return new ResponseEntity<List<Student>>(result,HttpStatus.OK);
	}
}
