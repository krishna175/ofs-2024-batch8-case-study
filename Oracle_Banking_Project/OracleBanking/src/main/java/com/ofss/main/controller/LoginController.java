package com.ofss.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ofss.main.entity.LoginDetails;
import com.ofss.main.services.LoginService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("userlogin")
public class LoginController {

	@Autowired
	LoginService loginService;
	
//	http://localhost:8080/userlogin/loginstatus
	@GetMapping("/loginstatus/{username}/{password}")
	public ResponseEntity<String> validateLogin(@PathVariable("username") String username,@PathVariable("password") String password){
		LoginDetails login = new LoginDetails(0, username, password);
		int customer = loginService.loginValidation(login);
		System.out.println(customer);
		if (customer > 0) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
	}
	
	
}	
