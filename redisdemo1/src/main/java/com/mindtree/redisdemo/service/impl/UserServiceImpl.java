package com.mindtree.redisdemo.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.mindtree.redisdemo.model.User;
import com.mindtree.redisdemo.repository.UserRepository;
import com.mindtree.redisdemo.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	private UserRepository userRepo;

	public UserServiceImpl(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	@Override
	public User addUser(User user)
	{
		userRepo.save(user);
		return user;
	}
	
	@Override
	public User getById(int id)
	{
		User user=userRepo.findById(id);
		return user;
	}
	
	@Override
	public Map<Integer, User> getAllUsers()
	{
		return userRepo.findAll();
	}
	
	@Override
	public User updateUser(User user)
	{
		userRepo.update(user);
		return user;
	}
	
	@Override
	public Map<Integer, User> deleteById(int id)
	{
		userRepo.delete(id);
		return getAllUsers();
	}
}
