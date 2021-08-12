package com.mindtree.schedulerdemo.service.impl;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.mindtree.schedulerdemo.model.User;
import com.mindtree.schedulerdemo.repository.UserRepository;
import com.mindtree.schedulerdemo.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository repo;
	
	@Autowired
	private MessageChannel output;
	
	public User addUser()
	{
		User user=new User();
		user.setName("user"+new Random().nextInt(374483));
		user.setAge(new Random().nextInt(32));
		user.setStatus("published");
		output.send(MessageBuilder.withPayload(user).build());
		User result=repo.save(user);
		return result;
	}
}
