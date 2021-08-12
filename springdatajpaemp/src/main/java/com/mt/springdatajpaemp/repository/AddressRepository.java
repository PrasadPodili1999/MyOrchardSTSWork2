package com.mt.springdatajpaemp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mt.springdatajpaemp.entity.Address;
import com.mt.springdatajpaemp.entity.Employee;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer>{

	@Query("select e from Employee e where id= :employeeid")
	public Employee getEmployee(int employeeid);
}
