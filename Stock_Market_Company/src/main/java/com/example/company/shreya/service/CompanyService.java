package com.example.company.shreya.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.company.shreya.dao.CompanyRepository;
import com.example.company.shreya.dto.CompanyDto;
import com.example.company.shreya.model.Company;

@Service
public class CompanyService {
	
	@Autowired
	CompanyRepository cRepo;
	
	ModelMapper mapper=new ModelMapper();
	
  
	
	public Iterable<CompanyDto> getAll()
	{	  mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	
	java.lang.reflect.Type targetListType = new TypeToken<Iterable<CompanyDto>>() {}.getType();
		  return mapper.map(cRepo.findAll(),targetListType);
		
	}
	
	public Iterable<CompanyDto> getCompanyBycName(String pattern)
	{	  mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	
	java.lang.reflect.Type targetListType = new TypeToken<Iterable<CompanyDto>>() {}.getType();
		  return mapper.map(cRepo.findBycNameContaining(pattern),targetListType);
		
	}
	
	public CompanyDto getCompanyById(int id)
	{
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(cRepo.findById(id).get(),CompanyDto.class);
	}
	
	public void insertCompany(CompanyDto companyDto)
	{
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		System.out.println(companyDto);
		cRepo.save(mapper.map(companyDto,Company.class));
	}
	
	public void updateCompany(CompanyDto companyDto,int id)
	{
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		cRepo.save(mapper.map(companyDto,Company.class));
	}
	
	public void deleteCompany(int id)
	{
		cRepo.deleteById(id);
	}
	public Iterable<CompanyDto> getCompanyBySector(String sector)
	{	  mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	
	java.lang.reflect.Type targetListType = new TypeToken<Iterable<CompanyDto>>() {}.getType();
		  return mapper.map(cRepo.findBysector(sector),targetListType);
		
	}
	public CompanyDto getCompanyByStockCode(String stockCode)
	{	  
		return mapper.map(cRepo.findByStockCode(stockCode).get(),CompanyDto.class);
		
	}
	
	

}
