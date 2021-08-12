package com.mt.fms.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mt.fms.model.Director;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class DirectorRepositoryTest {

	@MockBean
	DirectorRepository repo;
	
	@Test
	public void saveTest()
	{
		Director d=new Director(1, "jaffa", (byte)25, "male", (byte)5);
		when(repo.save(d)).thenReturn(d);
		Director d1=repo.save(d);
		assertEquals(1, d1.getId());
	}
	
	@Test
	public void findByNameTest()
	{
		Director d=new Director(1, "jaffa", (byte)25, "male", (byte)5);
		when(repo.findByName("jaffa")).thenReturn(d);
		Director d1=repo.findByName("jaffa");
		assertEquals("jaffa", d1.getName());
	}
	
	@Test
	public void findAllTest()
	{
		List<Director> dList=new ArrayList<Director>();
		Director d1=new Director(1, "jaffa", (byte)25, "male", (byte)5);
		Director d2=new Director(2, "daffa", (byte)35, "male", (byte)3);
		dList.add(d1);dList.add(d2);
		Iterable<Director> itr=dList;
		when(repo.findAll()).thenReturn(itr);
		List<Director> result=(List<Director>)repo.findAll();
		assertEquals(2, result.size());
	}
}
