package com.mindtree.schedulerdemo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.schedulerdemo.model.User;
import com.mindtree.schedulerdemo.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UserController {

	@Autowired
	UserService service;
	
	@Scheduled(cron = "0/15 * * * * *")
	@RequestMapping(value = "/getUsers",method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUsers()
	{
		List<User> result=service.getAllUsers();
		log.info("fetch service call in " + new Date().toString());
		log.info("no of users fetched :"+result.size());
		return new ResponseEntity<List<User>>(result,HttpStatus.OK);
	}
}
