package com.zee.zee5_app.service;

import java.util.List;
import java.util.Optional;

import com.zee.zee5_app.dto.Register;
import com.zee.zee5_app.exception.IdNotFoundException;

public interface UserService {
	
	public String addUser(Register register);
	public String updateUser(String id, Register register) throws IdNotFoundException;
	public Optional<Register> getUserById(String id) throws IdNotFoundException;
	public Register[] getAllUsers();
	public String deleteUserById(String id) throws IdNotFoundException;
	public List<Register> getAllUserDetails();

}
