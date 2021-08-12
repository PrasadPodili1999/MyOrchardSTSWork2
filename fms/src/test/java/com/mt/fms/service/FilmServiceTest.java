package com.mt.fms.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
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

import com.mt.fms.exception.InvalidDataException;
import com.mt.fms.exception.InvalidNameException;
import com.mt.fms.model.Director;
import com.mt.fms.model.Film;
import com.mt.fms.repository.FilmRepository;
import com.mt.fms.service.impl.FilmServiceImpl;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class FilmServiceTest {

	@InjectMocks
	FilmServiceImpl service;
	
	@MockBean
	FilmRepository repo;
	
	@Test
	public void addFilmTest() throws InvalidDataException
	{
		Set<Director> directors=new HashSet<>();
		Director d1=new Director(1, "jaffa", (byte)25, "male", (byte)3);
		directors.add(d1);
		Film f=new Film(1, "aaa", 5000, (byte)4, directors);
		when(repo.save(f)).thenReturn(f);
		Film result=service.addFilm(f);
		assertEquals(1, result.getId());
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
		
		when(service.getAllFilmsByDirectorName("jaffa"))
					.thenReturn(films.stream().collect(Collectors.toList()));
		List<Film> result=service.getAllFilmsByDirectorName("jaffa");
		assertEquals(2, result.size());
	}
	
	@Test
	public void deleteFilmByNameTest() throws InvalidNameException
	{
		List<Film> fList=new ArrayList<>();
		Film f1=new Film(1, "aaa", 5000, (byte)4);
		Film f2=new Film(2, "bbb", 10000, (byte)3);
		Film f3=new Film(3, "ccc", 12000, (byte)5);
		fList.add(f1);fList.add(f2);fList.add(f3);
		when(repo.findByName("ccc")).thenReturn(f3);
		when(service.deleteFilmByName("ccc"))
					.thenReturn(fList.stream().filter(m->!m.getName().equals("ccc"))
					.map(n->n).collect(Collectors.toList()));
		List<Film> result=service.deleteFilmByName("ccc");
		assertEquals(2, result.size());
	}
}
