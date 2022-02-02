package com.zee.zee5app;

import java.math.BigDecimal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.service.UserService;

@SpringBootApplication
public class Zee5appspringbootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext =
				SpringApplication.run(Zee5appspringbootApplication.class, args);
		
		UserService userService = applicationContext.getBean(UserService.class);
		Register register = new Register("reg0001", "Rithwik", "Chithreddy", "rithwik@gmail.com", "rith123", null);
		register.setContactNumber(new BigDecimal("9321654870"));
		System.out.println(userService.addUser(register));
		
		applicationContext.close();
	}

}
