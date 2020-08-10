package com.example.shreya.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.shreya.dto.StockExchangeDto;


@FeignClient("stockexchange")
public interface StockExchangeClient {
	
	@GetMapping(value= "/StockExchange")
	public Iterable<StockExchangeDto> getList();
	
	@PostMapping(value= "/StockExchange")
	public void addStockExchange(@RequestBody StockExchangeDto stockExchangeDto);
	
	

}
