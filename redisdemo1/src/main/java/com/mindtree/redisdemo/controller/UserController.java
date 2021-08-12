package com.mindtree.redisdemo.controller;

import java.util.Map;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.redisdemo.model.User;
import com.mindtree.redisdemo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private UserService service;

	public UserController(UserService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public User addUser(@RequestBody User user)
	{
		User result=service.addUser(user);
		return result;
	}
	
	@RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
	public User getById(@PathVariable("id") int id)
	{
		User result=service.getById(id);
		return result;
	}
	
	@RequestMapping(value = "/get",method = RequestMethod.GET)
	public Map<Integer, User> getAllUsers()
	{
		Map<Integer, User> resultMap=service.getAllUsers();
		return resultMap;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public User updateUser(@RequestBody User user)
	{
		User result=service.updateUser(user);
		return result;
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public Map<Integer, User> deleteById(@PathVariable("id") int id)
	{
		Map<Integer, User> resultMap=service.deleteById(id);
		return resultMap;
	}
}
