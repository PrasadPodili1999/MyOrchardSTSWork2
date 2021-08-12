package com.mindtree.eurekademo.service;

import java.util.List;

import com.mindtree.eurekademo.model.Student;

public interface SchoolService {

	public List<Student> getSchoolDetails(String schoolName);
}
