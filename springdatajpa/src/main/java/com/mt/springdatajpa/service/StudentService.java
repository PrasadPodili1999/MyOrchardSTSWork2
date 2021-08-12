package com.mt.springdatajpa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mt.springdatajpa.entity.Student;
import com.mt.springdatajpa.exceptionhandler.StudentNotFound;

@Service
public interface StudentService {

	public Student getStudentById(int id) throws StudentNotFound;
	public List<Student> getAllStudents();
	public Student createStudent(Student student);
	public Student updateStudent(Student student);
	public void deletePassport(int id) throws StudentNotFound;
	public void deleteAllStudents();
}
