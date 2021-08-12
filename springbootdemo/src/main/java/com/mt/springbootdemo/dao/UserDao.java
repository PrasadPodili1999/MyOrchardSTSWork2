package com.mt.springbootdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mt.springbootdemo.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
}