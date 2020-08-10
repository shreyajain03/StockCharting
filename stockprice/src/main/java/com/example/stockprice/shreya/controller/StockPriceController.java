package com.example.stockprice.shreya.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.stockprice.shreya.dto.StockPriceDto;
import com.example.stockprice.shreya.helper.ExcelHelper;
import com.example.stockprice.shreya.service.StockPriceService;




@RestController
public class StockPriceController {
 
	@Autowired
	StockPriceService stprService;
	
	@PostMapping("/StockPrice/upload")
	  public void uploadFile(@RequestParam("file") MultipartFile file){
	    String message = "";

	    if (ExcelHelper.hasExcelFormat(file)) {
	      try {
	    	  stprService.uploadExcel(file);

	        message = "Uploaded the file successfully: " + file.getOriginalFilename();
	        System.out.println(message);
	      } catch (Exception e) {
	        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	        System.out.println(message);
	        
	      }
	    }

	    message = "Please upload an excel file!";
	    System.out.println(message);
	  }
	
	
	@RequestMapping(value="/StockPrice")
	Iterable<StockPriceDto> getAll(){
		return stprService.getAll();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/StockPrice/{id}")
	StockPriceDto getStockPriceById(@PathVariable int id)
	{
		return stprService.getStockPriceById(id);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/StockPrice/StockExchange/{stockExchange}")
	Iterable<StockPriceDto> getStockPriceByStockExchange(@PathVariable String stockExchange)
	{
		return stprService.getStockPriceByStockExchange(stockExchange);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/StockPrice/{id}")
	void updateStockPrice(@RequestBody StockPriceDto StockPriceDto , @PathVariable int id)
	{
		stprService.updateStockPrice(StockPriceDto,id);
	}
	
	@PostMapping(value="/StockPrice")
	void insertStockPrice(@RequestBody StockPriceDto StockPriceDto)
	{
		stprService.insertStockPrice(StockPriceDto);
	}
	
	@DeleteMapping(value="/StockPrice/{id}")
	void deleteStockPrice(@PathVariable int id)
	{
		stprService.deleteStockPrice(id);
	}
	@RequestMapping(method=RequestMethod.GET,value="/StockPrice/date/{date1}/{date2}/{companyCode}")
	Iterable<StockPriceDto> getbyDate(@PathVariable String date1 ,@PathVariable String date2,@PathVariable String companyCode){
		
		return stprService.getbyDateRange(date1,date2,companyCode);
	}
	
}
