package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.EROLE;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.LoginRepository;
import com.zee.zee5app.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginRepository loginRepository;

	@Override
	public Login addCredentials(Login login) {
		// TODO Auto-generated method stub
		Login login2 = loginRepository.save(login);
		return login2;
	}

	@Override
	public String deleteCredentials(String username) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Login> optional = loginRepository.findById(username);
		if (optional.isEmpty())
			throw new IdNotFoundException("Record not found");
		else {
			loginRepository.deleteById(username);
			return "Success";
		}
	}

	@Override
	public String changePassword(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changeRole(String username, EROLE role) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Optional<List<Login>> getAllLoginDetails() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(loginRepository.findAll());
	}

}
