package com.example.company.shreya.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.company.shreya.dto.CompanyDto;
import com.example.company.shreya.service.CompanyService;

@RestController
public class CompanyController {
	
	@Autowired
	CompanyService cService;
	
	@RequestMapping(value="/Company")
	Iterable<CompanyDto> getAll(){
		return cService.getAll();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/Company/name/{id}")
	String getCompanyName(@PathVariable int id){
		return cService.getCompanyById(id).getCName();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/Company/pattern/{pattern}")
	Iterable<CompanyDto> getCompanyName(@PathVariable String pattern){
		return cService.getCompanyBycName(pattern);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/Company/{id}")
	CompanyDto getCompanyById(@PathVariable int id)
	{
		return cService.getCompanyById(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/Company/{id}")
	void updateCompany(@RequestBody CompanyDto companyDto , @PathVariable int id)
	{
		cService.updateCompany(companyDto,id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/Company")
	void insertCompany(@RequestBody CompanyDto companyDto)
	{
		cService.insertCompany(companyDto);
	}
	
	@DeleteMapping(value="/Company/{id}")
	void deleteCompany(@PathVariable int id)
	{
		cService.deleteCompany(id);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/Company/sector/{sector}")
	Iterable<CompanyDto> getCompanyBySector(@PathVariable String sector)
	{
		return cService.getCompanyBySector(sector);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/Company/StockCode/{stockCode}")
	CompanyDto getCompanyByStockCode(@PathVariable String stockCode)
	{
		return cService.getCompanyByStockCode(stockCode);
	}
	
	
	

}
