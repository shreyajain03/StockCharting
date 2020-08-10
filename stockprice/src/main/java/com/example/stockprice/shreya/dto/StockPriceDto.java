package com.example.stockprice.shreya.dto;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockPriceDto {
	int Id;
	String companyCode;
	String stockExchange;
	Long price;
	Date date;
	Time time;	
}
