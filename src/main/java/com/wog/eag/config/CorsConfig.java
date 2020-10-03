package com.wog.eag.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@PropertySource("classpath:application.properties")
@Configuration
public class CorsConfig {

	@Autowired
	private Environment environment;

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {

				String origins = environment.getProperty("allowed.origins");

				registry.addMapping("/**")
						.allowedMethods("GET", "PUT", "POST", "DELETE")
						.allowedHeaders("*")
						.allowedOrigins(origins.split(","))
						.allowCredentials(true);
			}
		};
	}
}