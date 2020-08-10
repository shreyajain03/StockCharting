package com.example.shreya.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.shreya.dto.StockPriceDto;

@FeignClient("stockprice")
public interface StockPriceClient {
	
	@GetMapping(value= "/StockPrice/date/{date1}/{date2}/{companyCode}")
	public Iterable<StockPriceDto> getStockPriceByDate(@PathVariable String date1,@PathVariable String date2,@PathVariable String companyCode);

}
