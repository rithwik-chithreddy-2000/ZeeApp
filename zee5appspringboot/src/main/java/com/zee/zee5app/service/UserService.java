package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.User;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;

public interface UserService {
	
	public User addUser(User register) throws AlreadyExistsException;
	public Optional<User> getUserById(Long id) throws IdNotFoundException;
	public User[] getAllUsers();
	public String deleteUserById(Long id) throws IdNotFoundException;
	public Optional<List<User>> getAllUserDetails();
	public User updateUser(User register) throws IdNotFoundException;

}
