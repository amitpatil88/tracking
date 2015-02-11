package com.javahelp.spring.integration.labs.domain;

import java.io.Serializable;

public class Address implements Serializable{

	private String firstLineOfAddress;
	
	private String city;
	
	private String postCode;
	
	protected enum AddressType {
		BILLING_ADDRESS,
		SHIPPING_ADDRESS;
	};
	
	protected AddressType type;
	
	public Address() {		
	}

	public Address(final String firstLineOfAddress, final String city, final String postCode) {
		this.firstLineOfAddress = firstLineOfAddress;
		this.city = city;
		this.postCode = postCode;
	}
	
	public String getFirstLineOfAddress() {
		return firstLineOfAddress;
	}

	public void setFirstLineOfAddress(String firstLineOfAddress) {
		this.firstLineOfAddress = firstLineOfAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public AddressType getType() {
		return type;
	}

	public void setType(AddressType type) {
		this.type = type;
	}

	
	
}
