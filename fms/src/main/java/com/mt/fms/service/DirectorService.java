package com.mt.fms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mt.fms.exception.InvalidDataException;
import com.mt.fms.exception.InvalidNameException;
import com.mt.fms.model.Director;


public interface DirectorService {

	public Director addDirector(Director director) throws InvalidDataException;
	public List<Director> getAllDirectorsByFilmName(String filmName);
	public Director getDirectorByName(String name) throws InvalidNameException;
	public Director updateDirectorAgeAndAwardByName(Director director)
			throws InvalidDataException, InvalidNameException;
	
}
