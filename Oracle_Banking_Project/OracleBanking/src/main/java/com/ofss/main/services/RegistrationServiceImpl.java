package com.ofss.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofss.main.entity.CustomerDetails;
import com.ofss.main.repository.CustomerRepository;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	CustomerRepository customerRepository;
	@Override
	public int addNewCustomer(CustomerDetails customerDetails) {
		// TODO Auto-generated method stub
		CustomerDetails newCustomer =  customerRepository.save(customerDetails);
		return newCustomer.getCustomerId();
	}

}
