package com.mindtree.eurekademo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.eurekademo.model.School;

@Repository
public interface SchoolServiceRepository extends CrudRepository<School, Integer>{

	public School findByName(String name);
}
