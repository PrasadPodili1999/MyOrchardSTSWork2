package com.mt.fms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
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
import com.mt.fms.service.FilmService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FilmServiceImpl implements FilmService {

	@Autowired
	FilmRepository filmRepo;

	@Autowired
	DirectorRepository directorRepo;

	@Override
	public Film addFilm(Film film) throws InvalidDataException {
		Film result= filmRepo.save(film);
		if(result==null)
		{
			log.error("invalid data entered");
			throw new InvalidDataException("invalid data entered");
		}
		else
		{
			return result;
		}
	}

	@Override
	public List<Film> getAllFilmsByDirectorName(String directorName) {
		log.info("data fetched from DB");
		Iterable<Film> itr = filmRepo.findAll();
		
		/*List<Film> films = new ArrayList<>();				//converting iterable to list in traditional way
		for (Film f : itr) {
			films.add(f);
		}*/
															//converting iterable to list using stream api
		List<Film> films=StreamSupport.stream(itr.spliterator(),false).collect(Collectors.toList());
		
															
															
		/*List<Film> result=new ArrayList<>();				//finding list of films having given director name
		for(Film f:films)									//		in traditional way
		{
			for(Director d:f.getDirectors())
			{
				if(d.getName().equals(directorName))
					result.add(f);
			}
		}*/

		List<Film> result=new ArrayList<>();				//finding list of films having given director name
		films.stream().forEach(f->{							//		using stream api type 1
			f.getDirectors().stream().forEach(d->{
				if (d.getName().equals(directorName)) {
					result.add(f);
				}
			});
		});

		//finding list of films having given director name
		//using stream api type 2
//		List<Film> result = films.stream().filter(f -> f.getDirectors()
//				.contains(directorRepo.findByName(directorName)))
//				.collect(Collectors.toList());
		return result;
	}

	@Override
	public List<Film> getAllFilms() {
		List<Film> films = (List<Film>) filmRepo.findAll();
		return films;
	}

	@Override
	public List<Film> deleteFilmByName(String name) throws InvalidNameException {
		log.info("data deleted in DB");
		Film film = filmRepo.findByName(name);
		if (film == null) {
			throw new InvalidNameException("no film is available with name :" + name);
		} else {
			filmRepo.deleteById(film.getId());
			return getAllFilms();
		}
	}
}
