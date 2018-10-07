package com.kumar.nitesh.repository;

import org.springframework.data.repository.CrudRepository;

import com.kumar.nitesh.model.User;


public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByUsername(String username);
}

