package com.zee.zee5_app.service.impl;

import com.zee.zee5_app.dto.Register;
import com.zee.zee5_app.repository.UserRepository;
import com.zee.zee5_app.repository.impl.UserRepositoryImpl;
import com.zee.zee5_app.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository = UserRepositoryImpl.getInstance();
	
	private UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	private static UserService service;
	public static UserService getInstance() {
		if(service==null)
			service = new UserServiceImpl();
		return service;
	}
	
	@Override
	public String addUser(Register register) {
		// TODO Auto-generated method stub
		return userRepository.addUser(register);
	}

	@Override
	public String updateUser(String id, Register register) {
		// TODO Auto-generated method stub
		return userRepository.updateUser(id, register);
	}

	@Override
	public Register getUserById(String id) {
		// TODO Auto-generated method stub
		return userRepository.getUserById(id);
	}

	@Override
	public Register[] getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.getAllUsers();
	}

	@Override
	public String deleteUserById(String id) {
		// TODO Auto-generated method stub
		return userRepository.deleteUserById(id);
	}

}
