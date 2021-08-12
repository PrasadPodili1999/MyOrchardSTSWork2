package com.mindtree.scheduleremo.service;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.mindtree.scheduleremo.model.User;
import com.mindtree.scheduleremo.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {

	@Autowired
	UserRepository repo;
	
	@Scheduled(fixedRate = 5000)
	public void addJobToDB()
	{
		User user=new User();
		user.setName("user"+new Random().nextInt(374483));
		repo.save(user);
		log.info("add service call in " + new Date().toString());
	}
	
	@Scheduled(cron = "0/15 * * * * *")
	public void fetchJobFromDB()
	{
		List<User> users=repo.findAll();
		log.info("fetch service call in " + new Date().toString());
		log.info("no of users fetched :"+users.size());
		log.info("users : {}",users);
	}
}
