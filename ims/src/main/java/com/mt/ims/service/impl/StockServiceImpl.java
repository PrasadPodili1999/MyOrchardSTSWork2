package com.mt.ims.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mt.ims.exception.StockNotFoundException;
import com.mt.ims.model.Stock;
import com.mt.ims.repository.StockRepository;
import com.mt.ims.service.StockService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StockServiceImpl implements StockService{

	@Autowired
	StockRepository repo;
	
//	@Override
//	public void addStock(Stock stock)
//	{
//		if(stock!=null)
//		{
//			repo.save(stock);
//		}
//	}
	@Override
	public List<Stock> getAllStocks()
	{
		Iterable<Stock> itr=repo.findAll();
		List<Stock> stockList=StreamSupport.stream(itr.spliterator(), false).collect(Collectors.toList());
		return stockList.stream().sorted().map(s->s).collect(Collectors.toList());
	}
	
	@Override
	public Stock getSpecificStock(String name) throws StockNotFoundException
	{
		log.info("data fetched from DB");
		Stock result=repo.findByProductType(name);
		if(result==null)
		{
			throw new StockNotFoundException();
		}
		else
		{
			return result;
		}
	}
}
