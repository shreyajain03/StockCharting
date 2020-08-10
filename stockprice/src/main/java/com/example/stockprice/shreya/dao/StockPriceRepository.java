package com.example.stockprice.shreya.dao;



import java.sql.Date;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.stockprice.shreya.model.StockPrice;

@Repository
public interface StockPriceRepository extends CrudRepository<StockPrice, Integer> {
	Iterable<StockPrice> findAllByDateLessThanEqualAndDateGreaterThanEqualAndCompanyCode(Date sd,Date ed,String companyCode);
	//Optional<StockPrice> findBystexc(String stexc);
	Iterable<StockPrice> findByStockExchange(String stockExchange);
}
