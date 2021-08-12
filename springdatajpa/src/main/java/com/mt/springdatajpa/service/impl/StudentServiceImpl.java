package com.mt.springdatajpa.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mt.springdatajpa.entity.Student;
import com.mt.springdatajpa.exceptionhandler.StudentNotFound;
import com.mt.springdatajpa.repository.StudentRepository;
import com.mt.springdatajpa.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	public StudentRepository studentRepository;

	public Student getStudentById(int id) throws StudentNotFound
	{
		Student student = studentRepository.findById(id).get();

		if(student==null)
		{
			throw new StudentNotFound();
		}
		else
		return student;
	}

	
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
	
	public Student createStudent(Student student)
	{
		
		return studentRepository.save(student);
		
	}
	public Student updateStudent(Student student)
	{
		return studentRepository.save(student);
	}
	
	public void deletePassport(int id) throws StudentNotFound
	{
		Student student=studentRepository.findById(id).get();
		if(student!=null)
		{
			studentRepository.deleteById(id);
		}
		else
		{
			throw new StudentNotFound();
		}
	}
	
	public void deleteAllStudents()
	{
		studentRepository.deleteAll();
	}
}
