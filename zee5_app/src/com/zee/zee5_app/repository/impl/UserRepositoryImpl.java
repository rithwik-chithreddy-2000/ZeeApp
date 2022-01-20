package com.zee.zee5_app.repository.impl;

import com.zee.zee5_app.dto.Register;
import com.zee.zee5_app.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {

	private Register[] registers = new Register[10];
	private static int count = -1;
	
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
		if(count==registers.length-1) {
			Register temp[] = new Register[registers.length*2];
			System.arraycopy(registers, 0, temp, 0, registers.length);
			registers = temp;
		}
		registers[++count] = register;
		return "Success";
	}

	@Override
	public String updateUser(String id, Register register) {
		// TODO Auto-generated method stub
		for (int i = 0; i < registers.length; i++) {
			if(registers[i].getId().equals(id)) {
				registers[i] = register;
				return "Updated";
			}
		}
		return "Id does not exist";
	}

	@Override
	public Register getUserById(String id) {
		// TODO Auto-generated method stub
		for (Register register : registers) {
			if(register != null && register.getId().equals(id))
				return register;
		}
		return null;
	}

	@Override
	public Register[] getAllUsers() {
		// TODO Auto-generated method stub
		return registers;
	}

	@Override
	public String deleteUserById(String id) {
		// TODO Auto-generated method stub
		for (int i = 0; i < registers.length; i++) {
			if(registers[i].getId().equals(id)) {
				System.arraycopy(registers, i+1, registers, i, count-i);
				registers[count--] = null;
				return "Deleted";
			}
		}
		return "Id does not exist";
	}

}
