package com.mt.mtm.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mt.mtm.dto.StudentDto;
import com.mt.mtm.model.Course;
import com.mt.mtm.model.Student;
import com.mt.mtm.repository.CourseRepository;
import com.mt.mtm.repository.StudentRepository;
import com.mt.mtm.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepository studentRepo;
	@Autowired
	CourseRepository courseRepo;
	
	@Transactional
	public StudentDto addStudent(StudentDto dto)
	{
		Student student=new Student();
		mapDtoToEntity(dto, student);
		Student savedStudent=studentRepo.save(student);
		return mapEntityToDto(savedStudent);
	}
	
	public StudentDto getStudentById(int id)
	{
		Optional<Student> student=studentRepo.findById(id);
		return mapEntityToDto(student.get());
	}
	
	public List<StudentDto> getAllStudents()
	{
		 List<StudentDto> studentDtos = new ArrayList<>();
	        List<Student> students = (List<Student>)studentRepo.findAll();
	        students.stream().forEach(student -> {
	            StudentDto studentDto = mapEntityToDto(student);
	            studentDtos.add(studentDto);
	        });
	        return studentDtos;
	}
	
	@Transactional
	public StudentDto updateStudent(int id,StudentDto dto)
	{
		Student student=studentRepo.findById(id).get();
		student.getCourses().clear();
		mapDtoToEntity(dto, student);
		Student std=studentRepo.save(student);
		return mapEntityToDto(std);
	}
	
	public String deleteStudentById(int id)
	{
		Optional<Student> student=studentRepo.findById(id);
		if(student.isPresent())
		{
			student.get().removeCourses();
			studentRepo.deleteById(student.get().getId());
			return "student with id :"+id+" deleted successfully";
		}
		return null;
	}
	
	private StudentDto mapEntityToDto(Student student)
	{
		 StudentDto responseDto = new StudentDto();
	        responseDto.setName(student.getName());
	        responseDto.setId(student.getId());
	        responseDto.setCourses(student.getCourses().stream().map(Course::getName).collect(Collectors.toSet()));
	        return responseDto;
	}
	
	private void mapDtoToEntity(StudentDto studentDto,Student student)
	{
		student.setName(studentDto.getName());
        if (null == student.getCourses()) {
            student.setCourses(new HashSet<>());
        }
        studentDto.getCourses().stream().forEach(courseName -> {
            Course course = courseRepo.findByName(courseName);
            if (null == course) {
                course = new Course();
                course.setStudents(new HashSet<>());
            }
            course.setName(courseName);
            student.addCourse(course);
        });
	}
	
}
