package com.zee.zee5_app.repository;

import com.zee.zee5_app.dto.Login;
import com.zee.zee5_app.dto.ROLE;

public interface LoginRepository {
	
	public String addCredentials(Login login);
	public String deleteCredentials(String userName);
	public String changePassword(String userName, String password);
	public String changeRole(String userName, ROLE role);

}
