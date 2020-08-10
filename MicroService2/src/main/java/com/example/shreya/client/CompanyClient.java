package com.example.shreya.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.shreya.dto.CompanyDto;

@FeignClient("company")
public interface CompanyClient {
	
	@GetMapping(value= "/Company/{id}")
	public CompanyDto getCompany(@PathVariable int id);
	
	@GetMapping(value="/Company/pattern/{pattern}")
	public Iterable<CompanyDto> getCompanyByPattern(@PathVariable String pattern);
	
	

}
