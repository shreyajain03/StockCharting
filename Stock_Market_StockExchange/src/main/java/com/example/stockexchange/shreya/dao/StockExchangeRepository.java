package com.example.stockexchange.shreya.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.stockexchange.shreya.model.StockExchange;

@Repository
public interface StockExchangeRepository extends CrudRepository<StockExchange,Integer>{
	
	

}
