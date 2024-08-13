package com.ofss.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ofss.main.entity.CustomerDetails;
import com.ofss.main.entity.LoginDetails;
import com.ofss.main.services.LoginService;
import com.ofss.main.services.RegistrationService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("obank")
public class LoginController {

	@Autowired
	LoginService loginService;
	@Autowired
	RegistrationService registrationService;
	
	int newCustomer = 0;
//	http://localhost:8080/obank/loginstatus
//	@GetMapping("/loginstatus/{username}/{password}")
//	public ResponseEntity<String> validateLogin(@PathVariable("username") String username,@PathVariable("password") String password){
//		LoginDetails login = new LoginDetails(0, username, password);
//		int customer = loginService.loginValidation(login);
//		System.out.println(customer);
//		if (customer > 0) {
//            return ResponseEntity.ok("Login successful");
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
//        }
//	}
	
	@PostMapping("loginstatus")
	public int validateUserLogin(@RequestBody LoginDetails loginDetails) {
		LoginDetails login = new LoginDetails(0,loginDetails.getUsername(),loginDetails.getPassword());
		int customerId = loginService.loginValidation(login);
		return customerId;
	}
	
	@PostMapping("newregistration")
	public int addNewCustomer(@RequestBody CustomerDetails customerDetails) {
		int newCustomerId = registrationService.addNewCustomer(customerDetails);
		newCustomer = newCustomerId;
		return newCustomer;
	}
	
	@PostMapping("newlogin")
	public LoginDetails addNewLogin(@RequestBody LoginDetails loginDetails){
//		LoginDetails newlogin = new LoginDetails(newCustomer, loginDetails.getUsername(), loginDetails.getPassword());
		return loginService.addNewLogin(loginDetails);
	}
	
	
	
}	
