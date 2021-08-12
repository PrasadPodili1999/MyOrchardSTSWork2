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
import com.mt.fms.service.DirectorService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class DirectorControllerTest {

	@InjectMocks
	DirectorController controller;
	
	@MockBean
	DirectorService service;
	
	@Test
	public void addDirectorTest() throws InvalidDataException
	{
		Director d=new Director();
		d.setId(1);
		when(service.addDirector(d)).thenReturn(d);
		ResponseEntity<Director> response=controller.addDirector(d);
		assertEquals(201, response.getStatusCode().value());
	}
	
	@Test
	public void getAllDirectorsByFilmNameTest()
	{
		Set<Film> films1=new HashSet<>();
		Film f1=new Film(1, "aaa", 250, (byte)8);
		films1.add(f1);
		Set<Director> directors=new HashSet<>();
		Director d1=new Director(1, "jaffa", (byte)50, "male", (byte)4,films1);
		Director d2=new Director(2,"duffi",(byte)30,"female",(byte)7,films1);
		directors.add(d1);directors.add(d2);
		f1.setDirectors(directors);
		when(service.getAllDirectorsByFilmName("aaa")).thenReturn(directors.stream().collect(Collectors.toList()));
		ResponseEntity<List<Director>> response=controller.getAllDirectorsByFilmName("aaa");
		assertEquals(200, response.getStatusCode().value());
		assertEquals(2, response.getBody().size());
	}
	
	@Test
	public void updateDirectorTest() throws InvalidDataException, InvalidNameException
	{
		Set<Film> films1=new HashSet<>();
		Film f1=new Film(1, "aaa", 250, (byte)8);
		films1.add(f1);
		Director d1=new Director(1, "jaffa", (byte)50, "male", (byte)4,films1);
		Director d2=new Director(1,"duffa",(byte)30,"female",(byte)7,films1);
		when(service.updateDirectorAgeAndAwardByName(d2)).thenReturn(d2);
		ResponseEntity<Director> response=controller.updateDirectorAgeAndAwardByName(d2);
		assertEquals(200, response.getStatusCode().value());
	}
}
