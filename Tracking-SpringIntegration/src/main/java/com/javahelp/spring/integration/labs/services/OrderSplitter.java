package com.javahelp.spring.integration.labs.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.splitter.AbstractMessageSplitter;
import org.springframework.messaging.Message;

import com.javahelp.spring.integration.labs.domain.Order;

public class OrderSplitter extends AbstractMessageSplitter {
	private static final Logger logger = LoggerFactory.getLogger("c.j.s.i.l.s.OrderSplitter");
	
	@Override
	protected Object splitMessage(Message<?> message) {
		logger.debug("*** [OrderSplitter] splitting Order into it's constituent OrderItems : number of OrderItems: "+ ((Order)message.getPayload()).getOrderItems().size() + " ****");
		return ((Order)message.getPayload()).getOrderItems();
	}

}
