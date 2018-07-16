package com.volvo.aurora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@ComponentScan(basePackages= {"com.aurora.entity","com.aurora.dao","com.aurora.service","com.aurora.controller"})
//@Configuration
//@ComponentScan
@SpringBootApplication

public class AuroraDemo3Application {

	
	public static void main(String[] args) {
		SpringApplication.run(AuroraDemo3Application.class, args);
		System.out.println("starts...........................................");
	}
}
