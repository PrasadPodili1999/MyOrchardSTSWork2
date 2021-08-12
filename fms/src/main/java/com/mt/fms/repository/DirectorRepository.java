package com.mt.fms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mt.fms.model.Director;

@Repository
public interface DirectorRepository extends CrudRepository<Director, Integer>{

	public Director findByName(String name);
	
}
