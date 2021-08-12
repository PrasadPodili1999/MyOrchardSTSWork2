package com.mt.manytomanydemo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mt.manytomanydemo.exceptionhandler.StudentNotFoundException;
import com.mt.manytomanydemo.model.Student;
import com.mt.manytomanydemo.repository.StudentRepository;
import com.mt.manytomanydemo.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepository studentRepo;
	
	public Student addStudent(Student student)
	{
		return studentRepo.save(student);
	}
	
	public List<Student> addStudent(List<Student> students)
	{
		List<Student> studentList=new ArrayList<>();
		Iterable<Student> itr=studentRepo.saveAll(students);
		for(Student student:itr)
		{
			studentList.add(student);
		}
		return studentList;
	}
	
	public Optional<Student> getStudentById(int id) throws StudentNotFoundException
	{
		Optional<Student> student=studentRepo.findById(id);
		if(student.isEmpty())
		{
			throw new StudentNotFoundException("student with id :"+id+" not available");
		}
		else
		{
			return student;
		}
	}
	
	public List<Student> getAllStudents()
	{
		List<Student> studentList=new ArrayList<>();
		Iterable<Student> itr=studentRepo.findAll();
		for(Student student:itr)
		{
			studentList.add(student);
		}
		return studentList;
	}
	public Student updateStudent(Student student)
	{
		return studentRepo.save(student);
	}
	
	public void deleteStudentById(int id) throws StudentNotFoundException
	{
		Optional<Student> student=getStudentById(id);
		if(student.isPresent())
		{
			studentRepo.deleteById(id);
			log.info("deleted successfully");
		}
		else
		{
			throw new StudentNotFoundException("student with id :"+id+" not available");
		}
	}
	
	public void deleteAllStudents() throws StudentNotFoundException
	{
		List<Student> list=getAllStudents();
		if(list.isEmpty())
		{
			throw new StudentNotFoundException("students  not available");
		}
		else
		{
			studentRepo.deleteAll();
			log.info("deleted successfully");
		}
	}
	
}
