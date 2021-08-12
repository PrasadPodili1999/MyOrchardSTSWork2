package com.mindtree.eurekademo.service;

import java.util.List;

import com.mindtree.eurekademo.exception.InvalidDataException;
import com.mindtree.eurekademo.exception.StudentNotFoundException;
import com.mindtree.eurekademo.model.Student;

public interface StudentService {

	public Student addStudent(Student student) throws InvalidDataException;
	
	public List<Student> getStudents(String schoolName) throws StudentNotFoundException;
}
