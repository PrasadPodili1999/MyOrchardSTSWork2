package com.mt.ims.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mt.ims.model.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer>{

	@Query(value = "{call  find_orders_by_custname(:cname)}", nativeQuery = true)
	public List<Order> getOrdersByCustomerName(@Param("cname") String cname);
	
	@Query(value = "{call  find_orders_by_stockname(:sname)}", nativeQuery = true)
	public List<Order> getOrdersByStockName(@Param("sname") String sname);
}
