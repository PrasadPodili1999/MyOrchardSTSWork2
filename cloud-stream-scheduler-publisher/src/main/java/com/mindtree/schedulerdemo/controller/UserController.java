package com.mindtree.schedulerdemo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.schedulerdemo.model.User;
import com.mindtree.schedulerdemo.service.UserService;

import kotlin.PublishedApi;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UserController {

	@Autowired
	UserService service;
	
	@Scheduled(fixedRate = 5000)
	@RequestMapping(value = "/addUser",method = RequestMethod.POST)
	public ResponseEntity<User> addUser()
	{
		User user=service.addUser();
		log.info("add service call in " + new Date().toString());
		return new ResponseEntity<User>(user,HttpStatus.CREATED);
	}
	
}
