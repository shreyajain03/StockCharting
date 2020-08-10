package com.example.shreya.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.shreya.dto.IPODetailDto;

@FeignClient("ipo")
public interface IPODetailClient {
	
	@GetMapping(value= "/IPODetail/name/{cName}")
	public IPODetailDto getIPODetailByCompany(@PathVariable String cName);

}
