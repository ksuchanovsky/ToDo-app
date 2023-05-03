package com.bezkoder.spring.jpa.postgresql.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class WebConfig  implements WebMvcConfigurer {

	@Value("${client.origin:#{null}}")
	private String clientOrigin;
		
	  @Override
	  public void addCorsMappings(CorsRegistry registry) {
		  
		  if (clientOrigin != null && !clientOrigin.isEmpty()) {
			  registry.addMapping("/**")
		      .allowedOrigins(clientOrigin);
		  }
	  }
	
}
