package com.test.pojos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.test.validate.CompanyValidator;

public class Company {
	
	Integer companyId;
	
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	@Autowired
	private CompanyValidator companyValidator;

	@Autowired
	private MessageSource messageSource;

	public MessageSource getMessageSource() {
		return messageSource;
	}
	public CompanyValidator getCompanyValidator() {
		return companyValidator;
	}
	String companyName;

	Address companyAddress;
	public String getCompanyName() {
		return companyName;
	}
	public Address getCompanyAddress() {
		return companyAddress;
	}
	
	public void setCompanyAddress(Address companyAddress) {
		this.companyAddress = companyAddress;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}
