package com.mt.fms.service;

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

import com.mt.fms.exception.InvalidDataException;
import com.mt.fms.exception.InvalidNameException;
import com.mt.fms.model.Director;
import com.mt.fms.model.Film;
import com.mt.fms.repository.DirectorRepository;
import com.mt.fms.repository.FilmRepository;
import com.mt.fms.service.impl.DirectorServiceImpl;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class DirectorServiceTest {

	@InjectMocks
	DirectorServiceImpl service;
	
	@MockBean
	DirectorRepository repo;
	
	@MockBean
	FilmRepository filmRepo;
	
	@Test
	public void addDirectorTest() throws InvalidDataException
	{
		Director d=new Director();
		d.setId(1);
		when(repo.save(d)).thenReturn(d);
		assertEquals(d, service.addDirector(d));
	}
	
	@Test
	public void getAllDirectorsByFilmNameTest()
	{
		Set<Film> films1=new HashSet<Film>();
		Film f1=new Film(1, "aaa", 250, (byte) 3);
		films1.add(f1);
		
		
		Set<Director> dSet1=new HashSet<>();
		Director d1=new Director(1, "jaffa", (byte)50, "male", (byte)4,films1);
		Director d2=new Director(2,"duffi",(byte)30,"female",(byte)7,films1);
		dSet1.add(d1);dSet1.add(d2);
		
		
		f1.setDirectors(dSet1);

		when(service.getAllDirectorsByFilmName("aaa")).thenReturn(dSet1.stream().collect(Collectors.toList()));
		assertEquals(2, service.getAllDirectorsByFilmName("aaa").size());
	}
	
	@Test
	public void updateDirectorByNameTest() throws InvalidDataException, InvalidNameException
	{
		Set<Film> films1=new HashSet<Film>();
		Film f1=new Film(1, "aaa", 250, (byte) 3);
		films1.add(f1);
		Director d1=new Director(1, "jaffa", (byte)50, "male", (byte)4,films1);
		Director d2=new Director(1, "jaffa", (byte)40, "female", (byte)10,films1);
		when(repo.findByName("jaffa")).thenReturn(d1);
		assertEquals(d1, service.getDirectorByName("jaffa"));
		when(repo.save(d2)).thenReturn(d2);
		//when(service.updateDirectorAgeAndAwardByName("duffa", d2)).thenThrow(InvalidNameException.class);
		Director d=service.updateDirectorAgeAndAwardByName(d2);
		assertEquals("jaffa", d.getName());
		assertEquals(40, d.getAge());
		assertEquals(10, d.getAwardCount());
		assertEquals("male", d.getGender());
	}
}
