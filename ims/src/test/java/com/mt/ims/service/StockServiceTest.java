package com.mt.ims.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mt.ims.exception.StockNotFoundException;
import com.mt.ims.model.Stock;
import com.mt.ims.repository.StockRepository;
import com.mt.ims.service.impl.StockServiceImpl;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class StockServiceTest {

	@InjectMocks
	StockServiceImpl service;
	
	@MockBean
	StockRepository repo;
	
	@Test
	public void getAllStocksTest()
	{
		List<Stock> sList=new ArrayList<>();
		Stock s1=new Stock(1, "laptop", 25000, 5);
		Stock s2=new Stock(2, "mobile", 30000, 10);
		sList.add(s1);sList.add(s2);
				
		when(service.getAllStocks()).thenReturn(sList);
		List<Stock> result=service.getAllStocks();
		assertEquals(2, result.size());
	}
	
	@Test
	public void getSpecificStockTest() throws StockNotFoundException
	{
		Stock s1=new Stock(1, "laptop", 25000, 5);
		when(repo.findByProductType("laptop")).thenReturn(s1);
		assertEquals(s1, repo.findByProductType("laptop"));
		when(service.getSpecificStock("laptop")).thenReturn(s1);
		Stock result=service.getSpecificStock("laptop");
		assertEquals("laptop", result.getProductType());
		assertEquals(1, result.getId());
	}
}
