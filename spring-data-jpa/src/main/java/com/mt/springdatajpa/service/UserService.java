package com.mt.springdatajpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mt.springdatajpa.dao.UserRepository;
import com.mt.springdatajpa.dao.UserRepositoryImpl;
import com.mt.springdatajpa.model.User;



@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserRepositoryImpl user;
	
	@PostConstruct
	public void initDb()
	{
		List<User> users=new ArrayList<>();
		users.add(new User("prasad","It",21));
		users.add(new User("madhu","At",22));
		users.add(new User("jackie","Bt",24));
		users.add(new User("ramesh","Ct",21));
		users.add(new User("maya","Dt",20));
		userRepo.saveAll(users);
	}
	
	public List<User> getUsers()
	{
		return userRepo.findAll();
	}
	public List<User> getUserByProfession(String profession)
	{
		return userRepo.getUserByProfession(profession);
	}
	
	public long countByage(int age)
	{
		return userRepo.countByAge(age);
	}
	
	public void deleteUserByName(String name)
	{
		user.deleteByName(name);
	}
	
	public List<User> getUsersByMultiCondition(String name,String profession)
	{
		return userRepo.getUsersByNameAndProfession(name, profession);
	}
	
//	public List<User> getUserByIgnoreCase(String name)
//	{
//		return userRepo.getUserByIgnoreCase(name);
//	}
//	
//	public List<User> getUsersByQuery()
//	{
//		return userRepo.getUsersCustamized();
//	}
	
}
