package com.example.ipodetails.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/*
1.	id
2.	Company Name
3.	Stock Exchange
4.	Price per share
5.	Total number of Shares
6.	Open Date Time
*/
@Entity
@Table( schema = "Ipo")
public class Ipo {

		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		int Id;
		
		@Column(name="cname")
		String cName;
		
		@Column(name="stexc")
		String stExc;

		@Column(name="priceps")
		Long pricePS;
		
		@Column(name="totshare")
		Long totShare;
		
		@Column(name="opendt")
		Date openDT;

		public int getId() {
			return Id;
		}

		public void setId(int id) {
			Id = id;
		}

		public String getcName() {
			return cName;
		}

		public void setcName(String cName) {
			this.cName = cName;
		}

		

		public String getsExc() {
			return stExc;
		}

		public void setsExc(String sExc) {
			this.stExc = sExc;
		}

		public Long getPricePS() {
			return pricePS;
		}

		public void setPricePS(Long pricePS) {
			this.pricePS = pricePS;
		}

		public Long getTotShare() {
			return totShare;
		}

		public void setTotShare(Long totShare) {
			this.totShare = totShare;
		}

		public Date getOpenDT() {
			return openDT;
		}

		public void setOpenDT(Date openDT) {
			this.openDT = openDT;
		}
		

}
