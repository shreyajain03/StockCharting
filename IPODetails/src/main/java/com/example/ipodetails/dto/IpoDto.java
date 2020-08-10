package com.example.ipodetails.dto;

import java.sql.Date;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IpoDto {
	int Id;
	
	
	String cName;
	
	
	String stExc;

	
	Long pricePS;
	
	
	Long totShare;
	
	
	Date openDT;

}
