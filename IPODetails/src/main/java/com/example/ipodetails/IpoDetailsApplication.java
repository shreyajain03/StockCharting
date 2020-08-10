package com.example.ipodetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class IpoDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(IpoDetailsApplication.class, args);
	}

}
