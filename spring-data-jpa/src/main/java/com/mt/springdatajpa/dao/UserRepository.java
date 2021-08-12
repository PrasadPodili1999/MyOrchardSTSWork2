package com.mt.springdatajpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mt.springdatajpa.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	

	public List<User> getUserByProfession(String profession);
	
	public long countByAge(int age);
	
	public void deleteByName(String name);
	
	
	//multi condition
	public List<User> getUsersByNameAndProfession(String name,String profession);
	
//	//Ignore case
//	public List<User> getUserByIgnoreCase(String name);
//	
//	@Query("select u from User u")
//	public List<User> getUsersCustamized();
}
