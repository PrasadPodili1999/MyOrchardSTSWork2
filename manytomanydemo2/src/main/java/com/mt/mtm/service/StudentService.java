package com.mt.mtm.service;

import java.util.List;

import com.mt.mtm.dto.StudentDto;

public interface StudentService {

	public StudentDto addStudent(StudentDto dto);
	public StudentDto getStudentById(int id);
	public List<StudentDto> getAllStudents();
	public StudentDto updateStudent(int id,StudentDto dto);
	public String deleteStudentById(int id);
}
