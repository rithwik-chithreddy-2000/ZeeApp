package com.zee.zee5_app.repository;

import com.zee.zee5_app.dto.Register;

public class UserRepository {
	
	private Register[] registers = new Register[10];
	private static int count = -1;
	private UserRepository() {
		// TODO Auto-generated constructor stub
	}
	
	public String addUser(Register register) {
		if(count==registers.length-1) {
			Register temp[] = new Register[registers.length*2];
			System.arraycopy(registers, 0, temp, 0, registers.length);
			registers = temp;
		}
		registers[++count] = register;
		return "Success";
	}

	public Register getUserById(String id) {
		for (Register register : registers) {
			if(register != null && register.getId().equals(id))
				return register;
		}
		return null;
	}
	
	public Register[] getAllUsers() {
		return registers;
	}
	
	public String updateUser(String id, Register register) {
		for (int i = 0; i < registers.length; i++) {
			if(registers[i].getId().equals(id)) {
				registers[i] = register;
				return "Updated";
			}
		}
		return "Id does not exist";
	}
	
	public String deleteUser(String id) {
		for (int i = 0; i < registers.length; i++) {
			if(registers[i].getId().equals(id)) {
				System.arraycopy(registers, i+1, registers, i, count-i);
				registers[count--] = null;
				return "Deleted";
			}
		}
		return "Id does not exist";
	}
	
	private static UserRepository repository;
	public static UserRepository getInstance() {
		if(repository==null)
			repository = new UserRepository();
		return repository;
	}

}
