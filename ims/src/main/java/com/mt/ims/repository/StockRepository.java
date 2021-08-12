package com.mt.ims.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mt.ims.model.Stock;

@Repository
public interface StockRepository extends CrudRepository<Stock, Integer>{

	public Stock findByProductType(String productType);
}
