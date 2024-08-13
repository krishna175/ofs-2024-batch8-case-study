package com.ofss.main.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ofss.main.entity.CustomerDetails;

public interface CustomerRepository extends CrudRepository<CustomerDetails, Integer> {
//	@Query("SELECT MAX(customer_id) from customer_master")
//	int findMaxCustomerId();
}
