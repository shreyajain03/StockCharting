package com.example.shreya.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.shreya.dto.CompanyDto;
import com.example.shreya.dto.StockExchangeDto;
import com.example.shreya.dto.StockPriceDto;


@FeignClient("company")
public interface CompanyClient {
	
	@GetMapping(value= "/Company/StockCode/{stockCode}")
	public CompanyDto getCompanyByStockCode(@PathVariable String stockCode);
	
	

}
