package com.example.company.shreya.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.company.shreya.model.Company;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Integer> {
	
	public Iterable<Company> findBycNameContaining(String pattern);
	
	public Iterable<Company> findBysector(String sector);
	
	public Optional<Company> findByStockCode(String stockCode);

}
