package com.mt.manytomanydemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mt.manytomanydemo.exceptionhandler.StudentNotFoundException;
import com.mt.manytomanydemo.model.Student;

@Service
public interface StudentService {

	public Student addStudent(Student student);
	public List<Student> addStudent(List<Student> students);
	public Optional<Student> getStudentById(int id) throws StudentNotFoundException;
	public List<Student> getAllStudents();
	public Student updateStudent(Student student);
	public void deleteStudentById(int id) throws StudentNotFoundException;
	public void deleteAllStudents() throws StudentNotFoundException;
}
