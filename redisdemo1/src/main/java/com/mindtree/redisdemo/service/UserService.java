package com.mindtree.redisdemo.service;

import java.util.Map;

import com.mindtree.redisdemo.model.User;

public interface UserService {

	public User addUser(User user);
	
	public User getById(int id);
	
	public Map<Integer, User> getAllUsers();
	
	public User updateUser(User user);
	
	public Map<Integer, User> deleteById(int id);
}
