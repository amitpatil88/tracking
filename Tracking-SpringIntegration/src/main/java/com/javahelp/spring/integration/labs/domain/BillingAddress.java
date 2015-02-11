package com.javahelp.spring.integration.labs.domain;

import java.io.Serializable;

public class BillingAddress extends Address implements Serializable{
	public BillingAddress() {		
		type = AddressType.BILLING_ADDRESS;
	}

	public BillingAddress(final String firstLineOfAddress, final String city, final String postCode) {		
		super(firstLineOfAddress, city, postCode);
		type = AddressType.BILLING_ADDRESS;
	}

}
