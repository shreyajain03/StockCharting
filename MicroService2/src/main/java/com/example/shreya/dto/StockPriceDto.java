package com.example.shreya.dto;

import java.sql.Date;
import java.sql.Time;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockPriceDto {
	
	
	

	String companyCode;
	String stExc;
	Long currPrice;
	Date date;
	Time time;	

}
