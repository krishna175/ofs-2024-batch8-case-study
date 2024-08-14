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
		
		if(checklogin != null) {
			if(checklogin.getLoginAttempts()<3 && checklogin.getCustomerStatus().equals("Valid")) {
				if(checklogin.getUsername().equals(logindetail.getUsername()) && checklogin.getPassword().equals(logindetail.getPassword())){
					System.out.println("Successfull login");
					checklogin.setLoginAttempts(0);
					loginRepository.save(checklogin);
					return checklogin.getCustomerId();
					
				}
				else if(!checklogin.getPassword().equals(logindetail.getPassword())) {
					checklogin.setLoginAttempts(checklogin.getLoginAttempts()+1);
					loginRepository.save(checklogin);
					System.out.println("Invalid login Credentials!");
					//wrong password
					return 2;
				}
			}
			else {
				checklogin.setCustomerStatus("Blocked");
				loginRepository.save(checklogin);
				System.out.println("Exhausted login Attempts, Your account is blocked");
				// Exhausted login attempts and blocked;
				return 3;
			}
		}
		else {
			System.out.println("Invalid Login Credentials");
		}
		return 0;
	}
	@Override
	public LoginDetails addNewLogin(LoginDetails loginDetails) {
		
		return loginRepository.save(loginDetails);
	}

}
