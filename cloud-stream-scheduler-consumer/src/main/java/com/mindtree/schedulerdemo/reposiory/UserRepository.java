package com.mindtree.schedulerdemo.reposiory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.schedulerdemo.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

}
