package com.zee.zee5_app.service.impl;

import java.io.IOException;

import com.zee.zee5_app.dto.Login;
import com.zee.zee5_app.dto.ROLE;
import com.zee.zee5_app.repository.LoginRepository;
import com.zee.zee5_app.repository.impl.LoginRepositoryImpl;
import com.zee.zee5_app.service.LoginService;

public class LoginServiceImpl implements LoginService {
	
	private LoginRepository loginRepository = LoginRepositoryImpl.getInstance();
	
	private LoginServiceImpl() throws IOException {
		// TODO Auto-generated constructor stub
	}
	
	private static LoginService service;
	public static LoginService getInstance() throws IOException {
		if(service==null)
			service = new LoginServiceImpl();
		return service;
	}

	@Override
	public String addCredentials(Login login) {
		// TODO Auto-generated method stub
		return loginRepository.addCredentials(login);
	}

	@Override
	public String deleteCredentials(String username) {
		// TODO Auto-generated method stub
		return loginRepository.deleteCredentials(username);
	}

	@Override
	public String changePassword(String username, String password) {
		// TODO Auto-generated method stub
		return loginRepository.changePassword(username, password);
	}

	@Override
	public String changeRole(String username, ROLE role) {
		// TODO Auto-generated method stub
		return loginRepository.changeRole(username, role);
	}

}
