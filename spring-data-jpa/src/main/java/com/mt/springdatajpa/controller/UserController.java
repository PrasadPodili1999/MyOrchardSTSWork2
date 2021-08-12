package com.mt.springdatajpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.mt.springdatajpa.model.User;
import com.mt.springdatajpa.service.UserService;

@RestController
@RequestMapping("/spring-data-jpa")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/getUsers")
	public List<User> getAllUsers()
	{
		return userService.getUsers();
	}
	@GetMapping("/getUserByProfession/{profession}")
	public List<User> getUsersByProfession(@PathVariable String profession)
	{
		return userService.getUserByProfession(profession);
	}
	@GetMapping("/getUserCountByAge/{age}")
	public long countUsersByAge(@PathVariable int age)
	{
		return userService.countByage(age);
	}
	@DeleteMapping("/delete/{name}")
	public void deleteUsersByName(@PathVariable String name)
	{
		 userService.deleteUserByName(name);
	}
	@GetMapping("/getUsersByNameAndProfession/{name}/{profession}")
	public List<User> getUsersByNameAndProfession(@PathVariable String name,@PathVariable String profession)
	{
		return userService.getUsersByMultiCondition(name, profession);
	}
//	@GetMapping("/getUsersByIgnoreCase/{name}")
//	public List<User> getUserByIgnoreCase(@PathVariable String name)
//	{
//		return userService.getUserByIgnoreCase(name);
//	}
//	@GetMapping("/getUsersByQuery")
//	public List<User> getUsersByQuery()
//	{
//		return userService.getUsersByQuery();
//	}
}
