package com.kumar.nitesh.repository;

import org.springframework.data.repository.CrudRepository;

import com.kumar.nitesh.model.Authority;


public interface AuthorityRepository extends CrudRepository<Authority, Long> {
	
	Authority findByRole(String role);
}

