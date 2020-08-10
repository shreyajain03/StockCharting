package com.example.loginsignup.shreya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.loginsignup.shreya.dto.LoginSignupDto;
import com.example.loginsignup.shreya.service.LoginSignupService;


@RestController
public class LoginSignupController {

	@Autowired
	LoginSignupService loginService;
	
	@RequestMapping(value="/Login")
	Iterable<LoginSignupDto> getAll(){
		return loginService.getAll();
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/Signup")
	void insertCompany(@RequestBody LoginSignupDto companyDto)
	{
		loginService.insertUser(companyDto);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/Login/{usernm}/{password}")
	LoginSignupDto getCompanyName(@PathVariable String usernm,@PathVariable String password){
		return loginService.getUserByUsernmAndPassword(usernm,password);
	}
}
