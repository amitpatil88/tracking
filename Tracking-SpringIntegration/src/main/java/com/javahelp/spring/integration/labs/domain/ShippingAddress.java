package com.javahelp.spring.integration.labs.domain;

import java.io.Serializable;
public class ShippingAddress extends Address implements Serializable{
	public ShippingAddress() {
		type = AddressType.SHIPPING_ADDRESS;		
	}
	
	public ShippingAddress(final String firstLineOfAddress, final String city, final String postCode) {		
		super(firstLineOfAddress, city, postCode);
		type = AddressType.SHIPPING_ADDRESS;
	}	

}
