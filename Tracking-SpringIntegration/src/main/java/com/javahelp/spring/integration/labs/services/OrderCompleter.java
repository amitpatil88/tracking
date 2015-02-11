package com.javahelp.spring.integration.labs.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.javahelp.spring.integration.labs.domain.Order;
import com.javahelp.spring.integration.labs.domain.OrderItem;

public class OrderCompleter {
	private static final Logger logger = LoggerFactory.getLogger("c.j.s.i.l.s.OrderCompleter");
	
	public Order prepareDelivery(List<OrderItem> orderItems) {
		final Order order = new Order();
		order.setOrderItems(orderItems);

		logger.debug("*** [OrderCompleter] CompletedOrder Discounted cost: " + order.getTotalDiscountedCost() +" ****");
		return order;
	}
}
