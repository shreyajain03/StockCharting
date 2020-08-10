package com.example.loginsignup.shreya.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.loginsignup.shreya.model.LoginSignup;


@Repository
public interface LoginSignupRepository  extends CrudRepository<LoginSignup, Integer>  {
	Optional<LoginSignup> findByUsernmAndPassword(String usernm,String password);
}
