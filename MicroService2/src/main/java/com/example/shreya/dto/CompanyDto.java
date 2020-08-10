package com.example.shreya.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto {
	
	int Id;
	String cName;

	int turnover;

	String ceo;

	String bod;

	boolean listed;
	
	String sector;

	String brief;

	String stockCode;

}
