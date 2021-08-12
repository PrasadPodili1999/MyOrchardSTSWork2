package com.mt.ims.service;

import java.util.List;

import com.mt.ims.exception.InvalidOrderException;
import com.mt.ims.exception.QuantityNotAvailableException;
import com.mt.ims.model.Order;

public interface OrderService {

	public Order placeOrder(Order order) throws InvalidOrderException, QuantityNotAvailableException;
	
	public List<Order> getOrdersByCustomerName(String name) throws InvalidOrderException;
	
	public List<Order> getOrdersByStockName(String name) throws InvalidOrderException;
}
