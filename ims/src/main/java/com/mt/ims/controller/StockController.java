package com.mt.ims.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mt.ims.exception.StockNotFoundException;
import com.mt.ims.model.Stock;
import com.mt.ims.service.StockService;

@RestController
@RequestMapping("/stock")
@EnableCaching
@CacheConfig(cacheNames = "stocks")
public class StockController {

	@Autowired
	StockService service;
	
	@RequestMapping(value = "/get",method = RequestMethod.GET)
	public ResponseEntity<List<Stock>> getAllStocks()
	{
		List<Stock> stocks=service.getAllStocks();
		return new ResponseEntity<List<Stock>>(stocks,HttpStatus.OK);
	}
	
	@Cacheable(value = "stocks",key = "#name")
	@RequestMapping(value = "/get/{name}",method = RequestMethod.GET)
	public ResponseEntity<Stock> getSpecificStock(@PathVariable("name")String name) throws StockNotFoundException
	{
		Stock stock=service.getSpecificStock(name);
		return new ResponseEntity<Stock>(stock,HttpStatus.OK);
	}
}
