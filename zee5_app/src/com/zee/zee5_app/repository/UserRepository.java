package com.zee.zee5_app.repository;

import com.zee.zee5_app.dto.Register;

public interface UserRepository {
	
	public String addUser(Register register);
	public String updateUser(String id, Register register);
	public Register getUserById(String id);
	public Register[] getAllUsers();
	public String deleteUserById(String id);

}
