package com.example.ipodetails.dao;



//import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ipodetails.dto.IpoDto;
import com.example.ipodetails.model.Ipo;

@Repository
public interface IpoRepository extends CrudRepository<Ipo, Integer>{
		public Ipo findBycName(String cName);

		//public Optional<Ipo> findBycName(String cName);
		
}
