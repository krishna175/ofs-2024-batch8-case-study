package com.ofss.main.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ofss.main.entity.LoginDetails;

@Repository
public interface LoginRepository extends CrudRepository<LoginDetails, Integer>{
	LoginDetails findByUsername(String username);

}
