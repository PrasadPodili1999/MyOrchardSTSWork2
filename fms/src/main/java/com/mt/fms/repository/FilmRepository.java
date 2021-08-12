package com.mt.fms.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mt.fms.model.Film;

@Repository
public interface FilmRepository extends CrudRepository<Film, Integer>{

	public Film findByName(String name);
}
