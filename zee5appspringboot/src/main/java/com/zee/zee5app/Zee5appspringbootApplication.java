package com.zee.zee5app;

import java.math.BigDecimal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.UserRepository;

@SpringBootApplication
public class Zee5appspringbootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext =
				SpringApplication.run(Zee5appspringbootApplication.class, args);
		
		UserRepository userRepository = applicationContext.getBean(UserRepository.class);

		try {
			Register register = new Register("reg0006", "Eishika", "Chithreddy", "eishika@gmail.com", "eish123", null);
			register.setContactNumber(new BigDecimal("9321654870"));
			String result = userRepository.addUser(register);
			System.out.println(result);
		} catch (InvalidIdLengthException | InvalidNameException | InvalidEmailException | InvalidPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		applicationContext.close();
	}

}
