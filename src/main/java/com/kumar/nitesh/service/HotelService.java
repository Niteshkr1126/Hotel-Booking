package com.kumar.nitesh.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kumar.nitesh.model.Hotel;
import com.kumar.nitesh.repository.HotelRepository;

@Service
public class HotelService {
	
	@Autowired
	private HotelRepository hotelRepository;
	
	public List<Hotel> getAllHotels() {
		List<Hotel> hotels = new ArrayList<Hotel>();
		hotelRepository.findAll().forEach(hotels::add);
		return hotels;		
	}
	
	public Hotel getHotelByName(String name) {
		return hotelRepository.findByName(name);
	}
	
	public List<Hotel> getHotelByCity(String city) {
		List<Hotel> hotels = new ArrayList<Hotel>();
		hotelRepository.findByCity(city).forEach(hotels::add);
		return hotels;		
	}
	
	public List<Hotel> getHotelByRating(String rating) {
		List<Hotel> hotels = new ArrayList<Hotel>();
		hotelRepository.findByRating(rating).forEach(hotels::add);
		return hotels;		
	}
}
