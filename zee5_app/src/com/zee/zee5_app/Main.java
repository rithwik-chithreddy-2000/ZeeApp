package com.zee.zee5_app;

import java.util.Optional;

import com.zee.zee5_app.dto.Register;
import com.zee.zee5_app.exception.IdNotFoundException;
import com.zee.zee5_app.exception.InvalidEmailException;
import com.zee.zee5_app.exception.InvalidIdLengthException;
import com.zee.zee5_app.exception.InvalidNameException;
import com.zee.zee5_app.exception.InvalidPasswordException;
import com.zee.zee5_app.service.UserService;
import com.zee.zee5_app.service.impl.UserServiceImpl;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserService service = UserServiceImpl.getInstance();
		for(int i = 1; i <= 19; i++) {
			Register register2 = new Register();
			try {
				register2.setId("ab0000"+i);
				register2.setFirstName("Rithwik"+i);
				register2.setLastName("Chithreddy"+i);
				register2.setPassword("rithwik123");
			} catch (InvalidIdLengthException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidNameException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidPasswordException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String result = service.addUser(register2);
			System.out.println(result+i);
		}
		
		try {
			Optional<Register> optional = service.getUserById("ab00001");
			System.out.println(optional.get());
		} catch (IdNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			Register register4 = new Register("rc00001", "Rithwik", "Chithreddy", "rithwikch@gmail.com", "rithwik123");
			System.out.println(register4);
		} catch (InvalidIdLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidEmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		service.getAllUserDetails().forEach(e->System.out.println(e));
		
//		try {
//			System.out.println(service.deleteUserById("ab00002"));
//		} catch (IdNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		service.getAllUserDetails().forEach(e->System.out.println(e));

	}

}
