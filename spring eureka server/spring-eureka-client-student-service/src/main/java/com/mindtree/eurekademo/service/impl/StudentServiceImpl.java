package com.mindtree.eurekademo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.eurekademo.exception.InvalidDataException;
import com.mindtree.eurekademo.exception.StudentNotFoundException;
import com.mindtree.eurekademo.model.Student;
import com.mindtree.eurekademo.repository.StudentServiceRepository;
import com.mindtree.eurekademo.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentServiceRepository repo;
	
	@Override
	public Student addStudent(Student student) throws InvalidDataException
	{
		if(student==null)
		{
			log.error("invalid data entered");
			throw new InvalidDataException();
		}
		else
		{
			return repo.save(student);
		}
	}
	
	@Override
	public List<Student> getStudents(String schoolName) throws StudentNotFoundException
	{
		Iterable<Student> itr=repo.findAll();
		List<Student> students=StreamSupport.stream(itr.spliterator(), false).collect(Collectors.toList());
		List<Student> list=students.stream()
				.filter(s->s.getSchool().getName().equals(schoolName))
				.map(m->m).collect(Collectors.toList());
		if(list==null)
		{
			throw new StudentNotFoundException();
		}
		else
		{
			return list;
		}
	}
}
