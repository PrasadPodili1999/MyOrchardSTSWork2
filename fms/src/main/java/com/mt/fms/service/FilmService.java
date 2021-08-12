package com.mt.fms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mt.fms.exception.InvalidDataException;
import com.mt.fms.exception.InvalidNameException;
import com.mt.fms.model.Film;


public interface FilmService {

	public Film addFilm(Film film) throws InvalidDataException;
	public List<Film> getAllFilms();
	public List<Film> deleteFilmByName(String name) throws InvalidNameException;
	public List<Film> getAllFilmsByDirectorName(String directorName);
}
