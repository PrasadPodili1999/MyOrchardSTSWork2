package com.mt.ims.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import com.mt.ims.exception.InvalidOrderException;
import com.mt.ims.exception.QuantityNotAvailableException;
import com.mt.ims.model.Customer;
import com.mt.ims.model.Order;
import com.mt.ims.model.Stock;
import com.mt.ims.service.OrderService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class OrderControllerTest {

	@InjectMocks
	OrderController controller;
	@MockBean
	OrderService service;
	
	@Test
	public void placeOrderTest() throws InvalidOrderException, QuantityNotAvailableException
	{
		Customer cust=new Customer(1, "smith");
		Stock stock=new Stock(1, "lenovo", 2500, 10);
		Order order1=new Order(1, cust, stock, 5);
		
		when(service.placeOrder(order1)).thenReturn(order1);
		ResponseEntity<Order> response=controller.placeOrder(order1);
		assertEquals(201, response.getStatusCode().value());
		assertEquals(1, response.getBody().getId());
	}
}
