package com.zee.zee5_app.service;

import com.zee.zee5_app.dto.Register;
import com.zee.zee5_app.repository.UserRepository;

public class UserService {
	
	private UserRepository repository = UserRepository.getInstance();
	private UserService() {
		// TODO Auto-generated constructor stub
	}
	
	public String addUser(Register register) {
		return this.repository.addUser(register);
	}
	
	public Register getUserById(String id) {
		return this.repository.getUserById(id);
	}
	
	public Register[] getAllUsers() {
		return this.repository.getAllUsers();
	}
	
	public String updateUser(String id, Register register) {
		return this.repository.updateUser(id, register);
	}
	
	public String deleteUser(String id) {
		return this.repository.deleteUser(id);
	}
	
	private static UserService service;
	public static UserService getInstance() {
		if(service==null)
			service = new UserService();
		return service;
	}

}
