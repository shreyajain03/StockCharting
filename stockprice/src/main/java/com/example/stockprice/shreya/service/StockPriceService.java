package com.example.stockprice.shreya.service;

import java.sql.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.stockprice.shreya.dao.StockPriceRepository;
import com.example.stockprice.shreya.dto.StockPriceDto;
import com.example.stockprice.shreya.helper.ExcelHelper;
import com.example.stockprice.shreya.model.StockPrice;


@Service

public class StockPriceService {
	@Autowired
	StockPriceRepository stprRepo;

	ModelMapper mapper=new ModelMapper();
	
	public Iterable<StockPriceDto> getAll()
	{	  mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	
	java.lang.reflect.Type targetListType = new TypeToken<Iterable<StockPriceDto>>() {}.getType();
		  return mapper.map(stprRepo.findAll(),targetListType);
		
	}
	
	public void uploadExcel(MultipartFile file) {
	    try {
	      List<StockPrice> stockPrice = ExcelHelper.excelToTutorials(file.getInputStream());
	      stprRepo.saveAll(stockPrice);
	    } catch (Exception e) {
	    	System.out.println("failed in service");
	      throw new RuntimeException("fail to store excel data: " + e.getMessage());
	    }
	  }
	
	public StockPriceDto getStockPriceById(int id)
	{
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(stprRepo.findById(id).get(),StockPriceDto.class);
	}
	
	public Iterable<StockPriceDto> getStockPriceByStockExchange(String stockExchange)
	{
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		java.lang.reflect.Type targetListType = new TypeToken<Iterable<StockPriceDto>>() {}.getType();
		return mapper.map(stprRepo.findByStockExchange(stockExchange),targetListType);
	}
	
	public void insertStockPrice(StockPriceDto StockPriceDto)
	{
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		stprRepo.save(mapper.map(StockPriceDto,StockPrice.class));
	}
	
	public void updateStockPrice(StockPriceDto StockPriceDto,int id)
	{
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		stprRepo.save(mapper.map(StockPriceDto,StockPrice.class));
	}
	
	public void deleteStockPrice(int id)
	{
		stprRepo.deleteById(id);
	}
	public Iterable<StockPriceDto> getbyDateRange(String sd,String ed,String companyCode)
	{	 
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		java.lang.reflect.Type targetListType = new TypeToken<Iterable<StockPriceDto>>() {}.getType();
		return mapper.map(stprRepo.findAllByDateLessThanEqualAndDateGreaterThanEqualAndCompanyCode(Date.valueOf(sd),Date.valueOf(ed),companyCode),targetListType);			
	}
	
	
}
