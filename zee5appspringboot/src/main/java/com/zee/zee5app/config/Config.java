package com.zee.zee5app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zee.zee5app.utils.PasswordUtils;

@Configuration
public class Config {
	
	@Bean
	public PasswordUtils passwordUtils() {
		return new PasswordUtils();
	}

}
