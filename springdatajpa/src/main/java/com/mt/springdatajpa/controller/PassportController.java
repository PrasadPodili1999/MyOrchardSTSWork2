package com.mt.springdatajpa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mt.springdatajpa.entity.Passport;
import com.mt.springdatajpa.entity.Student;
import com.mt.springdatajpa.repository.PassportRepository;
import com.mt.springdatajpa.service.PassportService;

@RestController
public class PassportController
{
	@Autowired
	public PassportService passportService;

	@GetMapping("/get/{id}")
	public ResponseEntity<Passport> getPassportById(@PathVariable("id") int id)
	{
		try
		{
			return ResponseEntity.status(HttpStatus.OK).body(passportService.getPassportById(id));
		}
		catch(Exception e)
		{
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}

	@GetMapping("/get")
	public ResponseEntity<List<Passport>> getAllPassport()
	{
		List<Passport> passportList = passportService.getAllPassport();

		return ResponseEntity.status(HttpStatus.OK).body(passportList);
	}

	@PostMapping("/addpassport")
	public ResponseEntity<Passport> createPassport(@RequestBody Passport passport)
	{
		
		return ResponseEntity.status(HttpStatus.CREATED).body(passportService.createPassport(passport));

	}
	
	@PutMapping("/update")
	public ResponseEntity<Passport> updatePassport(Passport passport)
	{
		return ResponseEntity.status(HttpStatus.OK).body(passportService.updatePassport(passport));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deletePassportById(@PathVariable("id") int id)
	{
		try
		{
			passportService.deletePassportById(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	@DeleteMapping("/delete")
	public ResponseEntity<Void> deleteAllPassports()
	{
			passportService.deleteAllPassports();
			return ResponseEntity.status(HttpStatus.OK).build();
	}
	
}
