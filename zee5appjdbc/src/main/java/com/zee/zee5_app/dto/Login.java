package com.zee.zee5_app.dto;

import lombok.Data;

@Data
public class Login {
	
	private String userName;
	private String password;
	private String regId;
	private ROLE role;

}
