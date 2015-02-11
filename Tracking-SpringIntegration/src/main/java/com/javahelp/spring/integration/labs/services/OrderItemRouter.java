package com.javahelp.spring.integration.labs.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.javahelp.spring.integration.labs.domain.Book;
import com.javahelp.spring.integration.labs.domain.MusicCD;
import com.javahelp.spring.integration.labs.domain.OrderItem;
import com.javahelp.spring.integration.labs.domain.Software;

public class OrderItemRouter {
	private static final Logger logger = LoggerFactory.getLogger("c.j.s.i.l.s.OrderItemRouter");
	
	public String routeOrder(OrderItem orderItem){
		String channel = "";
		logger.debug("**** [OrderItemRouter] *****");
		
		if(isBook(orderItem)) {
			channel = "booksItemChannel";
 		} else if(isMusic(orderItem)){
 			channel = "musicsItemChannel";
 		} else if(isSoftware(orderItem)){
 			channel = "softwaresItemChannel";
 		}
		
		logger.debug("*** [OrderItemRouter] sending item : " + orderItem.getItem().getTitle() + " to "+ channel +  " ****");

		return channel;
	}

	private boolean isSoftware(OrderItem orderItem) {
		return orderItem.getItem() instanceof Software;
	}

	private boolean isMusic(OrderItem orderItem) {
		return orderItem.getItem() instanceof MusicCD;
	}

	private boolean isBook(OrderItem orderItem) {
		return orderItem.getItem() instanceof Book;
	}
}
