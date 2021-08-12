package com.mt.fms.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mt.fms.model.Director;
import com.mt.fms.model.Film;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class FilmRepositoryTest {

	@MockBean
	FilmRepository repo;
	
	@Test
	public void saveTest()
	{
		Set<Director> directors=new HashSet<>();
		Director d1=new Director(1, "jaffa", (byte)25, "male", (byte)3);
		directors.add(d1);
		Film f=new Film(1, "aaa", 5000, (byte)4, directors);
		when(repo.save(f)).thenReturn(f);
		Film result=repo.save(f);
		assertEquals("aaa", result.getName());
	}
	
	@Test
	public void findAllTest()
	{
		List<Film> fList=new ArrayList<>();
		Film f1=new Film(1, "aaa", 5000, (byte)4);
		Film f2=new Film(2, "bbb", 10000, (byte)3);
		fList.add(f1);fList.add(f2);
		when(repo.findAll()).thenReturn(fList);
		List<Film> result=(List<Film>)repo.findAll();
		assertEquals(2, result.size());
	}
	
	@Test
	public void findByNameTest()
	{
		Film f1=new Film(1, "aaa", 5000, (byte)4);
		when(repo.findByName("aaa")).thenReturn(f1);
		Film result=repo.findByName("aaa");
		assertEquals("aaa", result.getName());
	}
	
}
