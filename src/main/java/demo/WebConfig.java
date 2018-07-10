package demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer  {

	public void addCorsMappings(org.springframework.web.servlet.config.annotation.CorsRegistry registry) {
		//registry.addMapping("/**").allowedOrigins("http://localhost:4200");
		registry.addMapping("/**").allowedOrigins("*");
	}
}
