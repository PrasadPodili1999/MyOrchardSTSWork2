package com.mt.springjpaontoone.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.mt.springjpaonetoone.entities.Address;
import com.mt.springjpaonetoone.entities.Employee;

@Repository
public interface EmpRepository extends JpaRepository<Employee, Integer>{

	@Query("select a from Address a where id= :addressId")
	public Address getStudent(int addressId);
}
