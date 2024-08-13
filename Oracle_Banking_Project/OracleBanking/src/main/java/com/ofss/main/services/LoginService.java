package com.ofss.main.services;

import org.springframework.stereotype.Service;

import com.ofss.main.entity.LoginDetails;

@Service
public interface LoginService {
	public int loginValidation(LoginDetails logindetail);
	public LoginDetails addNewLogin(LoginDetails loginDetails);
}
