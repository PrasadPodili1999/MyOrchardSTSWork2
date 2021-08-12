package com.mt.ims.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mt.ims.model.Stock;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class StockRepositoryTest {

	@MockBean
	StockRepository repo;
	
	@Test
	public void findAllTest()
	{
		List<Stock> sList=new ArrayList<>();
		Stock s1=new Stock(1, "laptop", 25000, 5);
		Stock s2=new Stock(2, "mobile", 30000, 10);
		sList.add(s1);sList.add(s2);
		Iterable<Stock> itr=sList;
		when(repo.findAll()).thenReturn(itr);
		List<Stock> result=(List<Stock>)repo.findAll();
		assertEquals(2, result.size());
	}
	
	@Test
	public void findByProductTypeTest()
	{
		Stock s1=new Stock(1, "laptop", 25000, 5);
		when(repo.findByProductType("laptop")).thenReturn(s1);
		Stock result=repo.findByProductType("laptop");
		assertEquals("laptop", result.getProductType());
		assertEquals(1, result.getId());
	}
}
