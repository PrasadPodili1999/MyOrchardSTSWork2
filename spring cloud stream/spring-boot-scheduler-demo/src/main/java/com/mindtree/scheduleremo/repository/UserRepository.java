package com.mindtree.scheduleremo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.scheduleremo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
