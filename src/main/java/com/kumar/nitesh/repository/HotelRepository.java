package com.kumar.nitesh.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kumar.nitesh.model.Hotel;

public interface HotelRepository extends CrudRepository<Hotel, String> {
	
	public Hotel findByName(String name);
	public List<Hotel> findByCity(String city);
	public List<Hotel> findByRating(String rating);

}