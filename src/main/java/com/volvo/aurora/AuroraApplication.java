package com.volvo.aurora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages= {"com.volvo.aurora","com.volvo.aurora.entity","com.volvo.aurora.repository","com.volvo.aurora.service"})
@SpringBootApplication
public class AuroraApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(AuroraApplication.class, args);
		
		System.out.println("Let's inspect the beans provided by Spring Boot:.............");

	}
}
