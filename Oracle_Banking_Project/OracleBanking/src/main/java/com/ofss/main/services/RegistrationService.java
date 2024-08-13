package com.ofss.main.services;

import org.springframework.stereotype.Service;

import com.ofss.main.entity.CustomerDetails;

@Service
public interface RegistrationService {
	public int addNewCustomer(CustomerDetails customerDetails);
}
