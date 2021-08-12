package com.mt.mtm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mt.mtm.dto.StudentDto;
import com.mt.mtm.service.StudentService;

@RestController

public class StudentController {

	@Autowired
	StudentService studentService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<StudentDto> addStudent(@RequestBody StudentDto studentDto)
	{
		StudentDto dto=studentService.addStudent(studentDto);
		return new ResponseEntity<>(dto,HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<StudentDto> getStudentById(@PathVariable("id") int id)
	{
		StudentDto dto=studentService.getStudentById(id);
		return new ResponseEntity<StudentDto>(dto,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public ResponseEntity<List<StudentDto>> getAllStudents()
	{
		List<StudentDto> dtos=studentService.getAllStudents();
		return new ResponseEntity<>(dtos,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<StudentDto> addStudent(@PathVariable("id") int id,
			@RequestBody StudentDto studentDto)
	{
		StudentDto dto=studentService.updateStudent(id, studentDto);
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteStudentById(@PathVariable("id") int id)
	{
		String msg=studentService.deleteStudentById(id);
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
}
