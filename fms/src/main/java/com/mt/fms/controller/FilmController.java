package com.mt.fms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
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
import com.mt.fms.model.Film;
import com.mt.fms.service.FilmService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/film")
@EnableCaching
@CacheConfig(cacheNames = "films")
public class FilmController {

	@Autowired
	FilmService filmService;
	
	@RequestMapping(value = "/addFilm",method = RequestMethod.POST)
	public ResponseEntity<Film> addFilm(@RequestBody Film film) throws InvalidDataException
	{
		Film f=filmService.addFilm(film);
		log.info("film added successfully");
		return new ResponseEntity<Film>(f,HttpStatus.CREATED);
	}
	
	@Cacheable(value = "films",key = "#directorName")
	@RequestMapping(value = "/getAllFilms/{directorName}",method = RequestMethod.GET)
	public ResponseEntity<List<Film>> getAllFilmByDirectorName(@PathVariable("directorName") String directorName)
	{
		List<Film> films=filmService.getAllFilmsByDirectorName(directorName);
		return new ResponseEntity<List<Film>>(films,HttpStatus.OK);
	}
	
	@CacheEvict(value = "films",allEntries = true)
	@RequestMapping(value = "/delete/{name}",method = RequestMethod.DELETE)
	public ResponseEntity<List<Film>> deleteByName(@PathVariable("name") String name) throws InvalidNameException
	{

		return ResponseEntity.status(HttpStatus.OK).body(filmService.deleteFilmByName(name));
//		catch(Exception e)
//		{
//			log.error("unable to delete film with name :"+name);
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//		}
	}
}
