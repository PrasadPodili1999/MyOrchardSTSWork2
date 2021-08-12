package com.mt.fms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mt.fms.exception.InvalidDataException;
import com.mt.fms.exception.InvalidNameException;
import com.mt.fms.model.Director;
import com.mt.fms.model.Film;
import com.mt.fms.repository.DirectorRepository;
import com.mt.fms.repository.FilmRepository;
import com.mt.fms.service.DirectorService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DirectorServiceImpl implements DirectorService {

	@Autowired
	DirectorRepository directorRepo;

	@Autowired
	FilmRepository filmRepo;

	@Override
	public Director addDirector(Director director) throws InvalidDataException {
		
		if(director==null)
		{
			log.info("please provide proper data");
			throw new InvalidDataException("invalid data entered");
		}
		 else {
			 Director result=directorRepo.save(director);
			return result;
		}
	}

	@Override
	public List<Director> getAllDirectorsByFilmName(String filmName) {
		log.info("data fetched from DB");
		Iterable<Director> itr = directorRepo.findAll();
		List<Director> directorList = StreamSupport.stream(itr.spliterator(), false).collect(Collectors.toList());

//		return directorList.stream().filter(d->d.getFilms()		//finding list of films having given director name
//				.contains(filmRepo.findByName(filmName)))		//			using stream api type1
//				.map(m->m).collect(Collectors.toList());
		List<Director> result = new ArrayList<>(); // finding list of films having given director name
		directorList.stream().forEach(f -> { // using stream api type 2
			f.getFilms().stream().forEach(d -> {
				if (d.getName().equals(filmName)) {
					result.add(f);
				}
			});
		});
		return result;
	}

	@Override
	public Director getDirectorByName(String name) throws InvalidNameException {
		log.info("data fetched from DB");
		Director director = directorRepo.findByName(name);
		if (director == null) {
			throw new InvalidNameException("no director is available with name :" + name);
		} else {
			return director;
		}
	}

	@Override
	public Director updateDirectorAgeAndAwardByName(Director director)
			throws InvalidDataException, InvalidNameException {
		log.info("updating data in DB");
		Director d = getDirectorByName(director.getName());
		if (d == null) {
			throw new InvalidNameException("no director is available with name :" + director.getName());
		} else {
			if (director.getAge() == d.getAge() || director.getAwardCount() == d.getAwardCount()) {
				throw new InvalidDataException("invalid data entered");
			} else {
				director.setId(d.getId());
				director.setName(d.getName());
				director.setGender(d.getGender());
				directorRepo.save(director);
				log.info("Director details updated successfully");
				return director;
			}
		}

	}

}
