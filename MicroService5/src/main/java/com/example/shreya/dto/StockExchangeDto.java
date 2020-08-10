package com.example.shreya.dto;

import java.sql.Date;
import java.sql.Time;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockExchangeDto {


	int id;

	String stockExchange;
	
	String brief;
	
	String contactAddress;
	
	String	remarks;
}
