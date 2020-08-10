package com.example.shreya.dto;



import java.sql.Date;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class IPODetailDto {
	
	/*int Id;
	
	String cName;
	
	String stockExchange;
	
	String pricePerShare;
	
	String totalShares;
	
	Timestamp openDateTime;
	
	String remarks;*/
int Id;
	
	
	String cName;
	
	
	String stExc;

	
	Long pricePS;
	
	
	Long totShare;
	
	
	Date openDT;


}
