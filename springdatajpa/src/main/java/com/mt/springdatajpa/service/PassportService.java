package com.mt.springdatajpa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mt.springdatajpa.entity.Passport;
import com.mt.springdatajpa.exceptionhandler.PassportNotFound;

@Service
public interface PassportService {

	public Passport createPassport( Passport passport);
	public Passport getPassportById(int id) throws PassportNotFound;
	public List<Passport> getAllPassport();
	public Passport updatePassport(Passport passport);
	public void deletePassportById( int id) throws PassportNotFound;
	public void deleteAllPassports();
}
