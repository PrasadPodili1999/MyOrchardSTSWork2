package com.mt.ims.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mt.ims.model.Customer;
import com.mt.ims.model.Order;
import com.mt.ims.model.Stock;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class OrderRepositoryTest {

	@MockBean
	OrderRepository repo;
	
	@Test
	public void saveTest()
	{
		Customer cust=new Customer(1, "smith");
		Stock stock=new Stock(1, "lenovo laptop", 2500, 10);
		Order order1=new Order(1, cust, stock, 5);
		when(repo.save(order1)).thenReturn(order1);
		Order order2=repo.save(order1);
		assertEquals(1, order2.getId());
	}
}
