package com.mt.fms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mt.fms.exception.InvalidDataException;
import com.mt.fms.exception.InvalidNameException;
import com.mt.fms.model.Director;
import com.mt.fms.service.DirectorService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/director")
@EnableCaching
@CacheConfig(cacheNames = "directors")
public class DirectorController {

	@Autowired
	DirectorService directorService;
	
	@RequestMapping(value = "/addDirector",method = RequestMethod.POST)
	public ResponseEntity<Director> addDirector(@RequestBody Director director) throws InvalidDataException
	{
		Director d=directorService.addDirector(director);
		log.info("director added successfully");
		return new ResponseEntity<Director>(d,HttpStatus.CREATED);
	}
	
	@CachePut(value = "directors",key = "#director.id")
	@RequestMapping(value = "/update",method = RequestMethod.PUT)
	public ResponseEntity<Director> updateDirectorAgeAndAwardByName(@RequestBody Director director) 
			throws InvalidDataException, InvalidNameException
	{
			return ResponseEntity.status(HttpStatus.OK).
					body(directorService.updateDirectorAgeAndAwardByName(director));
	}
	
	@Cacheable(value = "directors",key = "#filmName")
	@RequestMapping(value = "/getAllDirectors/{filmName}",method = RequestMethod.GET)
	public ResponseEntity<List<Director>> getAllDirectorsByFilmName(@PathVariable("filmName")String filmName)
	{
		List<Director> directors=directorService.getAllDirectorsByFilmName(filmName);
		return new ResponseEntity<List<Director>>(directors,HttpStatus.OK);
	}
}
