package com.example.loginsignup.shreya.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loginsignup.shreya.dao.LoginSignupRepository;
import com.example.loginsignup.shreya.dto.LoginSignupDto;
import com.example.loginsignup.shreya.model.LoginSignup;




@Service
public class LoginSignupService {
	@Autowired
	LoginSignupRepository loginRepo;
	
	ModelMapper mapper=new ModelMapper();
	
	public Iterable<LoginSignupDto> getAll()
	{	  mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	
	java.lang.reflect.Type targetListType = new TypeToken<Iterable<LoginSignupDto>>() {}.getType();
		  return mapper.map(loginRepo.findAll(),targetListType);
		
	}
	public LoginSignupDto getUserByUsernmAndPassword(String usernm,String password)
	{
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		return mapper.map(loginRepo.findByUsernmAndPassword(usernm,password).get(),LoginSignupDto.class);
	}
	
	public void insertUser(LoginSignupDto LoginSignupDto)
	{
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		System.out.println(LoginSignupDto);
		loginRepo.save(mapper.map(LoginSignupDto,LoginSignup.class));
	}
	
	
}
