package com.mindtree.redisdemo.repository;

import java.util.Map;

import com.mindtree.redisdemo.model.User;

public interface UserRepository {

	public void save(User user);
	
	public Map<Integer, User> findAll();
	
	public User findById(int id);
	
	public void update(User user);
	
	public void delete(int id);
}
