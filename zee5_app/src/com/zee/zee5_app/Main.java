package com.zee.zee5_app;

import com.zee.zee5_app.dto.Register;
import com.zee.zee5_app.service.UserService;
import com.zee.zee5_app.service.impl.UserServiceImpl;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Register register = new Register();
		
		register.setFirstName("Rithwik");
		register.setLastName("Chithreddy");
		register.setEmail("rithwik@gmail.com");
		register.setPassword("rithwik123");
		
		System.out.println(register);
		System.out.println(register.toString());
		System.out.println(register.getEmail());
		
		UserService service = UserServiceImpl.getInstance();
		for(int i = 1; i <= 19; i++) {
			Register register2 = new Register();
			register2.setId("ab00"+i);
			register2.setFirstName("Rithwik"+i);
			register2.setLastName("Chithreddy"+i);
			register2.setPassword("rithwik123");
			String result = service.addUser(register2);
			System.out.println(result+i);
		}
		
		Register register2 = service.getUserById("ab001");
		System.out.println(register2!=null);
		
		for (Register register3 : service.getAllUsers()) {
			if(register3!=null)
				System.out.println(register3);
		}

	}

}
