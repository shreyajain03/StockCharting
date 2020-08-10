package com.example.ipodetails.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ipodetails.dao.IpoRepository;
import com.example.ipodetails.dto.IpoDto;
import com.example.ipodetails.model.Ipo;
@Service
public class IpoService {

	@Autowired
	IpoRepository ipoRepo;
	
	ModelMapper mapper=new ModelMapper();
	
  
	
	public Iterable<IpoDto> getAll()
	{	  mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	
	java.lang.reflect.Type targetListType = new TypeToken<Iterable<IpoDto>>() {}.getType();
		  return mapper.map(ipoRepo.findAll(),targetListType);
		
	}
	
	public IpoDto getIpoById(int id)
	{
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(ipoRepo.findById(id).get(),IpoDto.class);
	}
	
	public void insertIpo(IpoDto ipoDto)
	{
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		ipoRepo.save(mapper.map(ipoDto,Ipo.class));
	}
	
	public void updateIpo(IpoDto ipoDto,int id)
	{
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		ipoRepo.save(mapper.map(ipoDto,Ipo.class));
	}
	
	public void deleteIpo(int id)
	{
		ipoRepo.deleteById(id);
	}
	public IpoDto findByCompanyName(String cName)
	{
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(ipoRepo.findBycName(cName),IpoDto.class);
	}
	
}
