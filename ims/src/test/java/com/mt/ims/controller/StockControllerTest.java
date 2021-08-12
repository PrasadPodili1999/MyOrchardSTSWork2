package com.mt.ims.controller;

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
import org.springframework.http.ResponseEntity;

import com.mt.ims.exception.StockNotFoundException;
import com.mt.ims.model.Stock;
import com.mt.ims.service.StockService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class StockControllerTest {

	@InjectMocks
	StockController controller;
	
	@MockBean
	StockService service;
	
	@Test
	public void getAllStocksTest()
	{
		List<Stock> sList=new ArrayList<>();
		Stock s1=new Stock(1, "laptop", 25000, 5);
		Stock s2=new Stock(2, "mobile", 30000, 10);
		sList.add(s1);sList.add(s2);
		
		when(service.getAllStocks()).thenReturn(sList);
		ResponseEntity<List<Stock>> response=controller.getAllStocks();
		assertEquals(200, response.getStatusCode().value());
		assertEquals(2, response.getBody().size());
	}
	
	@Test
	public void getSpecificStockTest() throws StockNotFoundException
	{
		Stock s1=new Stock(1, "laptop", 25000, 5);
		when(service.getSpecificStock("laptop")).thenReturn(s1);
		ResponseEntity<Stock> response=controller.getSpecificStock("laptop");
		assertEquals(200, response.getStatusCode().value());
		assertEquals(1, response.getBody().getId());
	}
}
