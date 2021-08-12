package com.mindtree.eurekademo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.eurekademo.model.Student;
import com.mindtree.eurekademo.service.SchoolService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class SchoolServiceController {

	@Autowired
	SchoolService service;

	@RequestMapping(value = "/getSchoolDetails/{schoolName}", method = RequestMethod.GET)
	public ResponseEntity<List<Student>> getSchoolDetails(@PathVariable("schoolName") String schoolName) {
		
		log.info("Getting School details for " + schoolName);
		List<Student> result = service.getSchoolDetails(schoolName);
		return new ResponseEntity<List<Student>>(result, HttpStatus.OK);
	}

}
