package com.example.ipodetails.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.ipodetails.dto.IpoDto;
import com.example.ipodetails.service.IpoService;


@RestController
public class IpoController {
	@Autowired
	IpoService ipoService;
	
	@RequestMapping(value="/Ipo")
	Iterable<IpoDto> getAll(){
		return ipoService.getAll();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/Ipo/{id}")
	IpoDto getIpoById(@PathVariable int id)
	{
		return ipoService.getIpoById(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/Ipo/{id}")
	void updateIpo(@RequestBody IpoDto IpoDto , @PathVariable int id)
	{
		ipoService.updateIpo(IpoDto,id);
	}
	
	@PostMapping(value="/Ipo")
	void insertIpo(@RequestBody IpoDto IpoDto)
	{
		ipoService.insertIpo(IpoDto);
	}
	
	@DeleteMapping(value="/Ipo/{id}")
	void deleteIpo(@PathVariable int id)
	{
		ipoService.deleteIpo(id);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/IPODetail/name/{cName}")
	IpoDto findByCompanyName(@PathVariable String cName)
	{
		return ipoService.findByCompanyName(cName);
	}
	
}
