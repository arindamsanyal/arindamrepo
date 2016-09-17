package com.test.pojos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

public class Address {
	@Autowired
	private MessageSource messageSource;
	private String city;
	private String country;
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
	private String state;
    
	public MessageSource getMessageSource() {
		return messageSource;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[\n Country : "+country+"\nCity : "+city+"\nState : "+state+"\n]";
	}
}
