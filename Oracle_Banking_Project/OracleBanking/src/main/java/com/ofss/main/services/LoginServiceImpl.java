package com.ofss.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofss.main.entity.LoginDetails;
import com.ofss.main.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	LoginRepository loginRepository;
	@Override
	public int loginValidation(LoginDetails logindetail) {
		
		LoginDetails checklogin = loginRepository.findByUsername(logindetail.getUsername());
		
		if(checklogin.getUsername().equals(logindetail.getUsername()) && checklogin.getPassword().equals(logindetail.getPassword())){
			System.out.println("Successfull login");
			return checklogin.getCustomerId();
			
		}
		else {
			System.out.println("Invalid login Credentials!");
			return 0;
		}
		
	}
	@Override
	public LoginDetails addNewLogin(LoginDetails loginDetails) {
		
		return loginRepository.save(loginDetails);
	}

}
