package com.mt.manytomanydemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mt.manytomanydemo.exceptionhandler.StudentCourseNotFoundException;
import com.mt.manytomanydemo.model.StudentCourse;
@Service
public interface StudentCourseService {

	public StudentCourse addStudentCourse(StudentCourse studentCourse);
	public List<StudentCourse> addStudentCourse(List<StudentCourse> studentCourses);
	public Optional<StudentCourse> getStudentCourseById(int id) throws StudentCourseNotFoundException;
	public List<StudentCourse> getAllStudentCourses();
	public StudentCourse updateStudentCourse(StudentCourse studentCourse);
	public void deleteStudentCourseById(int id) throws StudentCourseNotFoundException;
	public void deleteAllStudentCourses() throws StudentCourseNotFoundException;
}
