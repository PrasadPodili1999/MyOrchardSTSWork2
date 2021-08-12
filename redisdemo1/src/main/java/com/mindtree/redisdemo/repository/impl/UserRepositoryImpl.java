package com.mindtree.redisdemo.repository.impl;

import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.mindtree.redisdemo.model.User;
import com.mindtree.redisdemo.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository{

	private RedisTemplate<String, User> redisTemplate;
	
	private HashOperations hashOperations;

	public UserRepositoryImpl(RedisTemplate<String, User> redisTemplate) {
		
		this.redisTemplate = redisTemplate;
		hashOperations=redisTemplate.opsForHash();
	}
	
	@Override
	public void save(User user)
	{
		hashOperations.put("USER", user.getId(), user);
	}
	
	@Override
	public Map<Integer, User> findAll()
	{
		return hashOperations.entries("USER");
	}
	
	@Override
	public User findById(int id)
	{
		return (User)hashOperations.get("USER", id);
	}
	
	@Override
	public void update(User user)
	{
		hashOperations.put("USER", user.getId(), user);
	}
	
	@Override
	public void delete(int id)
	{
		hashOperations.delete("USER", id);
	}
}
