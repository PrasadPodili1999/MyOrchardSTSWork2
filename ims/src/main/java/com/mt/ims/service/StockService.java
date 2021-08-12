package com.mt.ims.service;

import java.util.List;

import com.mt.ims.exception.StockNotFoundException;
import com.mt.ims.model.Stock;

public interface StockService {

//	public void addStock(Stock stock);
	public List<Stock> getAllStocks();
	public Stock getSpecificStock(String name) throws StockNotFoundException;
}
