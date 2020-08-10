package com.example.shreya.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shreya.client.CompanyClient;
import com.example.shreya.client.StockExchangeClient;
import com.example.shreya.client.StockPriceClient;
import com.example.shreya.dto.CompanyDto;
import com.example.shreya.dto.StockExchangeDto;
import com.example.shreya.dto.StockPriceDto;

@RestController
@RequestMapping("/MicroService5")
public class MicroService5Controller {
	
	private StockExchangeClient seClient;
	private StockPriceClient spClient;
	private CompanyClient cClient;
	
	public MicroService5Controller(StockExchangeClient seClient, StockPriceClient spClient, CompanyClient cClient) {
		this.seClient = seClient;
		this.spClient = spClient;
		this.cClient = cClient;
	}

	@GetMapping("/StockExchange")
	public ResponseEntity<Iterable<StockExchangeDto>> getStockExchangeList() {
		return new ResponseEntity<>(seClient.getList(), HttpStatus.OK);
	}
	
	@GetMapping("/StockExchange/Company/{stockExchange}")
	public ResponseEntity<Iterable<CompanyDto>> getStockExchangeCompanyList(@PathVariable String stockExchange) {
		List<CompanyDto> s=new LinkedList<CompanyDto>();  
		Iterable<StockPriceDto> spDto = spClient.getListByStockExchange(stockExchange);
		for(StockPriceDto spdto:spDto)
		{
			
			s.add(cClient.getCompanyByStockCode(spdto.getCompanyCode()));
		}
		
		return new ResponseEntity<>(s, HttpStatus.OK);
	}
	
	@PostMapping("/StockExchange")
	public ResponseEntity<Void> addStockExchange(@RequestBody StockExchangeDto stockExchangeDto) {
		
		seClient.addStockExchange(stockExchangeDto);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

}
