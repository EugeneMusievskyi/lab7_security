package com.security.lab7.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserLoginForm {
	private String username;
	private String password;
}
