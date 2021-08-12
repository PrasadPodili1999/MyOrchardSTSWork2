package com.mt.springjpaontoone.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mt.springjpaonetoone.entities.Address;

@Repository
public interface AddRepository extends JpaRepository<Address, Integer>{

}
