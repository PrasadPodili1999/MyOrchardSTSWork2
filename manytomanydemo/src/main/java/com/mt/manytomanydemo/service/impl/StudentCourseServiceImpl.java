package com.mt.manytomanydemo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mt.manytomanydemo.exceptionhandler.CourseNotFoundException;
import com.mt.manytomanydemo.exceptionhandler.StudentCourseNotFoundException;
import com.mt.manytomanydemo.model.Course;
import com.mt.manytomanydemo.model.StudentCourse;
import com.mt.manytomanydemo.repository.CourseRepository;
import com.mt.manytomanydemo.repository.StudentCourseRepository;
import com.mt.manytomanydemo.service.StudentCourseService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StudentCourseServiceImpl implements StudentCourseService{

	@Autowired
	StudentCourseRepository studentCourseRepo;
	
	public StudentCourse addStudentCourse(StudentCourse studentCourse)
	{
		return studentCourseRepo.save(studentCourse);
	}
	
	public List<StudentCourse> addStudentCourse(List<StudentCourse> studentCourses)
	{
		List<StudentCourse> studentCourseList=new ArrayList<>();
		Iterable<StudentCourse> itr=studentCourseRepo.saveAll(studentCourses);
		for(StudentCourse studentCourse:itr)
		{
			studentCourseList.add(studentCourse);
		}
		return studentCourseList;
	}
	
	public Optional<StudentCourse> getStudentCourseById(int id) throws StudentCourseNotFoundException
	{
		Optional<StudentCourse> studentCourse=studentCourseRepo.findById(id);
		if(studentCourse.isEmpty())
		{
			throw new StudentCourseNotFoundException("Studentcourse with id :"+id+" not available");
		}
		else
		{
			return studentCourse;
		}
	}
	
	public List<StudentCourse> getAllStudentCourses()
	{
		List<StudentCourse> studentCourseList=new ArrayList<>();
		Iterable<StudentCourse> itr=studentCourseRepo.findAll();
		for(StudentCourse studentCourse:itr)
		{
			studentCourseList.add(studentCourse);
		}
		return studentCourseList;
	}
	public StudentCourse updateStudentCourse(StudentCourse studentCourse)
	{
		return studentCourseRepo.save(studentCourse);
	}
	
	public void deleteStudentCourseById(int id) throws StudentCourseNotFoundException
	{
		Optional<StudentCourse> studentCourse=getStudentCourseById(id);
		if(studentCourse.isPresent())
		{
			studentCourseRepo.deleteById(id);
			log.info("deleted successfully");
		}
		else
		{
			throw new StudentCourseNotFoundException("studentcourse with id :"+id+" not available");
		}
	}
	
	public void deleteAllStudentCourses() throws StudentCourseNotFoundException
	{
		List<StudentCourse> list=getAllStudentCourses();
		if(list.isEmpty())
		{
			throw new StudentCourseNotFoundException("studentcourses  not available");
		}
		else
		{
			studentCourseRepo.deleteAll();
			log.info("deleted successfully");
		}
	}
}
