package com.mt.ims.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mt.ims.exception.InvalidOrderException;
import com.mt.ims.exception.QuantityNotAvailableException;
import com.mt.ims.model.Order;
import com.mt.ims.service.OrderService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService service;
	
	@RequestMapping(value = "/addOrder",method = RequestMethod.POST)
	public ResponseEntity<Order> placeOrder(@RequestBody Order order) throws InvalidOrderException, QuantityNotAvailableException
	{
		Order result=service.placeOrder(order);
		log.info("order placed successfully");
		return new ResponseEntity<Order>(result,HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/getByCustomer/{cname}",method = RequestMethod.GET)
	public ResponseEntity<List<Order>> getOrdersByCustomerName(@PathVariable("cname") String cname) throws InvalidOrderException
	{
		List<Order> result=service.getOrdersByCustomerName(cname);
		return new ResponseEntity<List<Order>>(result,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getByStock/{sname}",method = RequestMethod.GET)
	public ResponseEntity<List<Order>> getOrdersByStockName(@PathVariable("sname") String sname) throws InvalidOrderException
	{
		List<Order> result=service.getOrdersByStockName(sname);
		return new ResponseEntity<List<Order>>(result,HttpStatus.OK);
	}
}
