package com.example.shreya.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shreya.client.CompanyClient;
import com.example.shreya.dto.CompanyDto;


@RestController
@RequestMapping("/MicroService3")
public class MicroService3Controller {
	
	
	private CompanyClient companyClient;


	public MicroService3Controller(CompanyClient companyClient ) {
		
		this.companyClient = companyClient;

	}
	
	@GetMapping("/Sector/{sector}")
	public ResponseEntity<Iterable<CompanyDto>> getCompanyBySector(@PathVariable String sector) {
		return new ResponseEntity<>(companyClient.getCompanyBySector(sector), HttpStatus.OK);
	}
	
	
	
	

}
