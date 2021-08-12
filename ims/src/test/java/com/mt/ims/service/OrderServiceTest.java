package com.mt.ims.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mt.ims.exception.InvalidOrderException;
import com.mt.ims.exception.QuantityNotAvailableException;
import com.mt.ims.model.Customer;
import com.mt.ims.model.Order;
import com.mt.ims.model.Stock;
import com.mt.ims.repository.OrderRepository;
import com.mt.ims.repository.StockRepository;
import com.mt.ims.service.impl.OrderServiceImpl;
import com.mt.ims.service.impl.StockServiceImpl;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class OrderServiceTest {

	@InjectMocks
	OrderServiceImpl service;

	@MockBean
	OrderRepository repo;
	
	@MockBean
	StockRepository stockRepo;
	
	@Test
	public void placeOrderTest() throws InvalidOrderException, QuantityNotAvailableException
	{
		Customer cust=new Customer(1, "smith");
		Stock stock=new Stock(1, "lenovo", 2500, 10);
		
		when(stockRepo.findByProductType("lenovo")).thenReturn(stock);
		Stock stockResult=stockRepo.findByProductType("lenovo");
		assertEquals(1, stockResult.getId());
		
		Order order1=new Order(1, cust, stock, 5);
		
		when(repo.save(order1)).thenReturn(order1);
		assertEquals(order1, repo.save(order1));
		assertEquals(order1, service.placeOrder(order1));
		assertEquals(5, stockRepo.findByProductType("lenovo").getQuantity());
		
	}
}
