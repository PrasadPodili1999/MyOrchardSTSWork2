package com.mindtree.schedulerdemo.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.mindtree.schedulerdemo.model.User;
import com.mindtree.schedulerdemo.reposiory.UserRepository;
import com.mindtree.schedulerdemo.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository repo;
	
	public List<User> getAllUsers()
	{
		List<User> users=(List<User>)repo.findAll();
		if(users!=null)
		{
			users.stream().forEach(user->user.setStatus("consumed"));
			repo.saveAll(users);
		}
		return users;
	}
}
