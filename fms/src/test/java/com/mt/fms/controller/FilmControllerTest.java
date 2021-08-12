package com.mt.fms.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import com.mt.fms.exception.InvalidDataException;
import com.mt.fms.exception.InvalidNameException;
import com.mt.fms.model.Director;
import com.mt.fms.model.Film;
import com.mt.fms.service.FilmService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class FilmControllerTest {

	@InjectMocks
	FilmController controller;
	
	@MockBean
	FilmService service;
	
	@Test
	public void addFilmTest() throws InvalidDataException
	{
		Set<Director> directors=new HashSet<>();
		Director d1=new Director(1, "jaffa", (byte)25, "male", (byte)3);
		directors.add(d1);
		Film f=new Film(1, "aaa", 5000, (byte)4, directors);
		ResponseEntity<Film> response=controller.addFilm(f);
		assertEquals(201, response.getStatusCode().value());
	}
	
	@Test
	public void getAllFilmsByDirectorNameTest()
	{
		Set<Director> directors=new HashSet<>();
		Director d1=new Director(1, "jaffa", (byte)25, "male", (byte)3);
		directors.add(d1);
		Set<Film> films=new HashSet<>();
		Film f1=new Film(1, "aaa", 5000, (byte)4, directors);
		Film f2=new Film(2, "bbb", 10000, (byte)3, directors);
		films.add(f1);films.add(f2);
		d1.setFilms(films);
		
		when(service.getAllFilmsByDirectorName("jaffa")).thenReturn(films.stream().collect(Collectors.toList()));
		ResponseEntity<List<Film>> response=controller.getAllFilmByDirectorName("jaffa");
		assertEquals(200, response.getStatusCode().value());
		assertEquals(2, response.getBody().size());
	}
	
	@Test
	public void deleteFilmByNameTest() throws InvalidNameException
	{
		List<Film> fList=new ArrayList<>();
		Film f1=new Film(1, "aaa", 5000, (byte)4);
		Film f2=new Film(2, "bbb", 10000, (byte)3);
		Film f3=new Film(3, "ccc", 12000, (byte)5);
		fList.add(f1);fList.add(f2);fList.add(f3);
		when(service.deleteFilmByName("ccc"))
					.thenReturn(fList.stream().filter(m->!m.getName().equals("ccc"))
					.map(n->n).collect(Collectors.toList()));
		ResponseEntity<List<Film>> response=controller.deleteByName("ccc");
		assertEquals(200, response.getStatusCode().value());
		assertEquals(2, response.getBody().size());
					
	}
}
