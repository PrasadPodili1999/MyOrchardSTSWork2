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

import com.mt.manytomanydemo.model.Student;
import com.mt.manytomanydemo.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping(value = "/addStudent",method = RequestMethod.POST)
	public ResponseEntity<Student> addStudent(@RequestBody Student student)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.addStudent(student));
	}
	
	@RequestMapping(value = "/addStudents",method = RequestMethod.POST)
	public ResponseEntity<List<Student>> addStudent(@RequestBody List<Student> students)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.addStudent(students));
	}
	
	@RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
	public ResponseEntity<Optional<Student>> getStudentById(@PathVariable("id") int id) 
	{
		try
		{
			return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudentById(id));
		}catch(Exception e){
			//e.printStackTrace();
			log.error("student not available");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	@RequestMapping(value = "/get",method = RequestMethod.GET)
	public ResponseEntity<List<Student>> getAllStudents()
	{
		return ResponseEntity.status(HttpStatus.FOUND).body(studentService.getAllStudents()); 
	}
	@RequestMapping(value = "/update",method = RequestMethod.PUT)
	public ResponseEntity<Student> updateStudent(@RequestBody Student student)
	{
		return ResponseEntity.status(HttpStatus.OK).body(studentService.updateStudent(student));
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteStudentById(@PathVariable("id") int id)
	{
		try
		{
			studentService.deleteStudentById(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		catch(Exception e)
		{
			log.error("student was not found "+e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}
		
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteAllStudents()
	{
		try
		{
			studentService.deleteAllStudents();
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		catch(Exception e)
		{
			log.error("students was not found "+e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

}
