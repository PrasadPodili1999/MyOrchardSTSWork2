package com.mt.springdatajpa.dao;

import org.springframework.beans.factory.annotation.Autowired;

public class UserRepositoryImpl  {

	@Autowired
	private UserRepository user;
	
	public void deleteByName(String name)
	{
		user.deleteByName(name);
	}
}
