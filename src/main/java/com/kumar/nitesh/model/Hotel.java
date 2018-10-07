package com.kumar.nitesh.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Hotels")
public class Hotel {

	@Id
	private String id;
	private String address;
	private String categories;
	private String city;
	private String country;
	private String latitude;
	private String longitude;
	private String name;
	private String postalcode;
	private String province;
	private String rating;
	private String text;
	private String title;
	private String username;
	
	
	public Hotel() {
		super();
	}
	public Hotel(String id, String address, String categories, String city, String country, String latitude,
			String longitude, String name, String postalcode, String province, String rating, String text, String title,
			String username) {
		super();
		this.id = id;
		this.address = address;
		this.categories = categories;
		this.city = city;
		this.country = country;
		this.latitude = latitude;
		this.longitude = longitude;
		this.name = name;
		this.postalcode = postalcode;
		this.province = province;
		this.rating = rating;
		this.text = text;
		this.title = title;
		this.username = username;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCategories() {
		return categories;
	}
	public void setCategories(String categories) {
		this.categories = categories;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}