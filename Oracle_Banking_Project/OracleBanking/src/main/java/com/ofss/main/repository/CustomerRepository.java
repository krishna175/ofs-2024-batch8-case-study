package com.ofss.main.repository;

import org.springframework.data.repository.CrudRepository;

import com.ofss.main.entity.CustomerDetails;

public interface CustomerRepository extends CrudRepository<CustomerDetails, Integer> {

}
