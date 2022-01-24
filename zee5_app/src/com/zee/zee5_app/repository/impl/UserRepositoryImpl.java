package com.zee.zee5_app.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;

import com.zee.zee5_app.dto.Register;
import com.zee.zee5_app.exception.IdNotFoundException;
import com.zee.zee5_app.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {
	
	private TreeSet<Register> set = new TreeSet<Register>();
	private UserRepositoryImpl() {
		// TODO Auto-generated constructor stub
	}
	
	private static UserRepository repository;
	public static UserRepository getInstance() {
		if(repository==null)
			repository = new UserRepositoryImpl();
		return repository;
	}
	@Override
	public String addUser(Register register) {
		// TODO Auto-generated method stub
		boolean result = this.set.add(register);
		if(result)
			return "Success";
		return "Fail";
	}
	@Override
	public String updateUser(String id, Register register) throws IdNotFoundException {
		// TODO Auto-generated method stub
		String result = this.deleteUserById(id);
		if(result=="Failed")
			return "Failed";
		result = this.addUser(register);
		if(result=="Fail")
			return "Failed";
		return "Updated";
	}
	@Override
	public Optional<Register> getUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Register register2 = null;
		for (Register register : set) {
			if(register.getId().equals(id)) {
				register2 = register;
				break;
			}
		}
		return Optional.of(Optional.ofNullable(register2).orElseThrow(() -> new IdNotFoundException("id not found")));
	}
	@Override
	public Register[] getAllUsers() {
		// TODO Auto-generated method stub
		Register register[] = new Register[set.size()];
		return set.toArray(register);
	}
	@Override
	public String deleteUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Register> optional = this.getUserById(id);
		boolean result = set.remove(optional.get());
		if(result)
			return "Deleted";
		return "Failed";
	}
	@Override
	public List<Register> getAllUserDetails() {
		// TODO Auto-generated method stub
//		ArrayList<Register> arrayList = new ArrayList<Register>(set);
//		Collections.sort(arrayList);
//		return arrayList;
		return new ArrayList<Register>(set.descendingSet());
	}

}
