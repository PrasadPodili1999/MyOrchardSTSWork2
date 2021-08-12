package com.mt.onetomanydemo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mt.onetomanydemo2.model.Department;

@Repository
public interface DeptRepository extends JpaRepository<Department, Integer>{

}
