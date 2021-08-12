package com.mt.springdatajpaemp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.mt.springdatajpaemp.controller.AddressController;
import com.mt.springdatajpaemp.entity.Address;
import com.mt.springdatajpaemp.entity.Employee;
import com.mt.springdatajpaemp.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	AddressRepository addressRepository;
	
	
	public void createAddress(int employeeid,Address address)
	{
		Employee employee=addressRepository.getEmployee(employeeid);
		address.setEmployee(employee);
		
		 addressRepository.save(address);
		
		
	}
	
}
