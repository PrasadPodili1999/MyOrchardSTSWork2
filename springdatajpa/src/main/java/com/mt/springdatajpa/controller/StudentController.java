package com.mt.springdatajpa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mt.springdatajpa.entity.Passport;
import com.mt.springdatajpa.entity.Student;
import com.mt.springdatajpa.repository.StudentRepository;
@RestController
public class StudentController
{
	@Autowired
	public StudentRepository studentRepository;

	@GetMapping("/student/{id}")
	public Student getStudentById(@PathVariable("id") int id)
	{
		Student student = studentRepository.findById(id).get();

		return student;
	}

	@GetMapping("/students")
	public List<Student> getAllStudents()
	{
		List<Student> studentList = new ArrayList<>();
		Iterable<Student> student = studentRepository.findAll();

		for (Student s : student)
		{
			studentList.add(s);
		}

		return studentList;
	}
	
	@PostMapping("/student")
	public Student createStudent(@RequestBody Student student)
	{
		Passport passport = new Passport();
		passport.setId(4);
		passport.setNumber("D123456");
		passport.setStudent(student);
		
		student.setPassport(passport);
		
		studentRepository.save(student);
		
		return getStudentById(student.getId());
	}
	
	@DeleteMapping("/student/{id}")
	public List<Student> deletePassport(@PathVariable("id") int id)
	{
		studentRepository.deleteById(id);

		return getAllStudents();
	}
}
