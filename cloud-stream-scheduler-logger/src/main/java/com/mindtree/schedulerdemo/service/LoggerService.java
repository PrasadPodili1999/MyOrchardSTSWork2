package com.mindtree.schedulerdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.mindtree.schedulerdemo.model.User;
import com.mindtree.schedulerdemo.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LoggerService {

	@Autowired
	UserRepository repo;
	
	@Autowired
	private MessageChannel output;
	
	@Scheduled(fixedRate = 10000)
	public void loggerService()
	{
		List<User> users=(List<User>)repo.findAll();
		if(users!=null)
		{
			users.stream().forEach(user->user.setStatus("queued"));
			repo.saveAll(users);
		}
		output.send(MessageBuilder.withPayload(users).build());
		log.info("data queued");
	}
}
