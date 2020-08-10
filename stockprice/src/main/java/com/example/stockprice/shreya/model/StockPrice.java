package com.example.stockprice.shreya.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * 1.	Company Code
2.	Stock Exchange
3.	Current Price
4.	Date
5.	Time
*/
 
 @Entity
 @Table( schema = "stockprice")
public class StockPrice {
	
	 @Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		int Id;
		@Column(name="companycode")
		String companyCode;
		
		@Column(name="stockExchange")
		String stockExchange;
		
		@Column(name="price")
		Long price;
		
		@Column(name="date")
		Date date;
		
		@Column(name="time")
		Time time;
		
		public int getId() {
			return Id;
		}

		public void setId(int id) {
			Id = id;
		}

		public String getCompanyCode() {
			return companyCode;
		}

		public void setCompanyCode(String companyCode) {
			this.companyCode = companyCode;
		}

		public String getStockExchange() {
			return stockExchange;
		}

		public void setStockExchange(String stockExchange) {
			this.stockExchange = stockExchange;
		}


		

		

		public Long getPrice() {
			return price;
		}

		public void setPrice(Long price) {
			this.price = price;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public Time getTime() {
			return time;
		}

		public void setTime(Time time) {
			this.time = time;
		}

		
		
}
