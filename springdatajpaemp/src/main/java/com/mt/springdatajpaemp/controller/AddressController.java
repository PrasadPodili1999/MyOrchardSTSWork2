package com.mt.springdatajpaemp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mt.springdatajpaemp.entity.Address;
import com.mt.springdatajpaemp.entity.Employee;
import com.mt.springdatajpaemp.repository.AddressRepository;
import com.mt.springdatajpaemp.service.AddressService;

@RestController
public class AddressController {
	
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	AddressService addressService;
	
	@GetMapping("/address/{id}")
	public Address getAddressById(@PathVariable("id") int id)
	{
		Address address=addressRepository.findById(id).get();
		return address;
	}
	
	@GetMapping("/addresses")
	public List<Address> getAllAddress()
	{
		List<Address> addressList=new ArrayList<>();
		Iterable<Address> address=addressRepository.findAll();
		for(Address a : address)
		{
			addressList.add(a);
		}
		return addressList;
	}
	@PostMapping("/address/{employeeid}")
	public Address createAddress(@PathVariable("employeeid") int employeeid,
			@RequestBody Address address)
	{		
		 addressService.createAddress(employeeid, address);
		return getAddressById(address.getId());
	}
	@DeleteMapping("/address/{id}")
	public List<Address> deleteAddressById(@PathVariable("id") int id)
	{
		addressRepository.deleteById(id);
		return getAllAddress();
	}
}
