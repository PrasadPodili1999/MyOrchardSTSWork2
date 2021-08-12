package com.mt.ims.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mt.ims.exception.InvalidOrderException;
import com.mt.ims.exception.QuantityNotAvailableException;
import com.mt.ims.model.Order;
import com.mt.ims.model.Stock;
import com.mt.ims.repository.OrderRepository;
import com.mt.ims.repository.StockRepository;
import com.mt.ims.service.OrderService;
import com.mt.ims.service.StockService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderRepository repo;
	
	@Autowired
	StockRepository stockRepo;
	
	
	@Override
	public Order placeOrder(Order order) throws InvalidOrderException, QuantityNotAvailableException
	{
		if(order!=null)
		{
			Stock stock=stockRepo.findByProductType(order.getStock().getProductType());
			int restQuantity=stock.getQuantity()-order.getQuantity();
			if(stock==null)
			{
				throw new InvalidOrderException();
			}
			else if(order.getQuantity()>stock.getQuantity())
			{
				throw new QuantityNotAvailableException("Available Quantity Of Stock : "+restQuantity);
			}
			else
			{
				Order result=repo.save(order);
				stock.setId(order.getStock().getId());
				stock.setQuantity(restQuantity);
				Stock stockResult=stockRepo.save(stock);
				return result;
			}
		}
		else
		{
			throw new InvalidOrderException();
		}
		
	}
	
	public List<Order> getOrdersByCustomerName(String name) throws InvalidOrderException
	{
		List<Order> result=repo.getOrdersByCustomerName(name);
		if(result!=null)
		{
			return result;
		}
		else {
			throw new InvalidOrderException(); 
		}
	}
	public List<Order> getOrdersByStockName(String name) throws InvalidOrderException
	{
		List<Order> result=repo.getOrdersByStockName(name);
		if(result!=null)
		{
			return result;
		}
		else {
			throw new InvalidOrderException(); 
		}
	}
}
