package com.test.pojos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

public class Address {

	List<String> cities = new ArrayList<String>();
	Map<String, String> citiesMap = new HashMap<String, String>();

	{
		cities.add("Pune");
		cities.add("Bangalore");
		cities.add("Guwahati");
		cities.add("Jaipur");

		citiesMap.put("Guwahati", "0123");
		citiesMap.put("Bangalore", "02345");

	}
	
	Integer addressId;

	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public Map<String, String> getCitiesMap() {
		return citiesMap;
	}
	public void setCitiesMap(Map<String, String> citiesMap) {
		this.citiesMap = citiesMap;
	}
	public List<String> getCities() {
		return cities;
	}
	public void setCities(List<String> cities) {
		this.cities = cities;
	}

	@Autowired
	private MessageSource messageSource;
	private String city;
	private String country;
	private String state;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[\n Country : " + country + "\nCity : " + city + "\nState : "
				+ state + "\n]";
	}
}
