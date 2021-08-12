package com.mt.springdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mt.springdatajpa.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
