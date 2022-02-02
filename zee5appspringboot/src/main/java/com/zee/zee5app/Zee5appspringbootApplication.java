package com.zee.zee5app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.service.UserService;

@SpringBootApplication
public class Zee5appspringbootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext =
				SpringApplication.run(Zee5appspringbootApplication.class, args);
		
		UserService userService = applicationContext.getBean(UserService.class);
		System.out.println("Add User");
		for (int i = 1; i <= 5; i++) {
			Register register = new Register("reg000"+i, "Rithwik"+i, "Chithreddy"+i, "rithwik"+i+"@gmail.com", "rith123"+i, "932165487"+i);
			System.out.println(userService.addUser(register) + " " + i);
		}
		System.out.println();
		
		System.out.println("Get User by Id");
		System.out.println(userService.getUserById("reg0004").get());
		System.out.println();
		
		System.out.println("Get All User Details - List");
		userService.getAllUserDetails().get().forEach(e->System.out.println(e));
		System.out.println();
		
		System.out.println("Delete Record by Id");
		try {
			System.out.println(userService.deleteUserById("reg0003"));
		} catch (IdNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println();
		
		System.out.println("Get All User Details - Array");
		for (Register register : userService.getAllUsers()) {
			System.out.println(register);
		}
		System.out.println();
		
		applicationContext.close();
	}

}
