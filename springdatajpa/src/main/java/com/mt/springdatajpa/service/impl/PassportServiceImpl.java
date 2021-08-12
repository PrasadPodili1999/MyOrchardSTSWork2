package com.mt.springdatajpa.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mt.springdatajpa.entity.Passport;
import com.mt.springdatajpa.entity.Student;
import com.mt.springdatajpa.exceptionhandler.PassportNotFound;
import com.mt.springdatajpa.repository.PassportRepository;
import com.mt.springdatajpa.service.PassportService;


@Service
public class PassportServiceImpl implements PassportService{

	@Autowired
	public PassportRepository passportRepository;
	
	public Passport createPassport( Passport passport)
	{
//		Student student = passportRepository.getStudent(studentid);
//		
//		passport.setStudent(student);
		
		return passportRepository.save(passport);

		//return getPassportById(passport.getId());
	}

	public Passport getPassportById(int id) throws PassportNotFound
	{
		Passport passport = passportRepository.findById(id).get();
		if(passport==null)
		{
			throw new PassportNotFound();
		}
		else
		return passport;
	}

	public List<Passport> getAllPassport()
	{
		List<Passport> passportList = new ArrayList<>();
		Iterable<Passport> passport = passportRepository.findAll();

		for (Passport p : passport)
		{
			passportList.add(p);
		}

		return passportList;
	}

	public Passport updatePassport(Passport passport)
	{
		return passportRepository.save(passport);
	}
	
	
	public void deletePassportById( int id) throws PassportNotFound
	{
		Passport passport=passportRepository.findById(id).get();
		if(passport!=null)
		{
			passportRepository.deleteById(id);
		}
		else
		{
			throw new PassportNotFound();
		}
		
	}
	
	public void deleteAllPassports()
	{
		 passportRepository.deleteAll();
	}
}
