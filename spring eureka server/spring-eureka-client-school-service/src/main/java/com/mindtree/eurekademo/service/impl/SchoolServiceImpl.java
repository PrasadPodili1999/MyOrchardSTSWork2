package com.mindtree.eurekademo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mindtree.eurekademo.model.School;
import com.mindtree.eurekademo.model.Student;
import com.mindtree.eurekademo.repository.SchoolServiceRepository;
import com.mindtree.eurekademo.service.SchoolService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SchoolServiceImpl implements SchoolService{

	@Autowired
	RestTemplate template;
	
	@Autowired
	SchoolServiceRepository repo;
	
	public List<Student> getSchoolDetails(String schoolName)
	{
		List<Student> response=template.exchange("http://student-service/getStudentDetailsForSchool/{schoolName}"
				, HttpMethod.GET,null,new ParameterizedTypeReference<List<Student>>(){},schoolName).getBody();
		
//		String url="http://student-service/getStudentDetailsForSchool/{schoolName}";
//		String response=template.getForObject(url, String.class);
		
		log.info("Response Received as " + response);
		//School school=repo.findByName(schoolName);
		return response;
	}
	
	public School getSchoolByName(String schoolName)
	{
		School school=repo.findByName(schoolName);
		return school;
	}
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}
}
