package com.javahelp.spring.integration.labs.services;

import org.springframework.integration.annotation.Gateway;

import com.javahelp.spring.integration.labs.domain.Order;

public interface Shop {
	
	@Gateway(requestChannel="ordersChannel")
	void placedOrder(Order order);
}
