package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages= {"com.training.entity","com.training.repository","com.training.dao","com.training.service","com.training.controller"})
@SpringBootApplication
public class AuroraDemo2Application {

	public static void main(String[] args) {
		
		SpringApplication.run(AuroraDemo2Application.class, args);
		
		System.out.println("Let's inspect the beans provided by Spring Boot:.............");

	}
}
