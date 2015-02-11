package com.javahelp.spring.integration.labs.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.javahelp.spring.integration.labs.domain.Book;
import com.javahelp.spring.integration.labs.domain.MusicCD;
import com.javahelp.spring.integration.labs.domain.Order;
import com.javahelp.spring.integration.labs.domain.OrderItem;
import com.javahelp.spring.integration.labs.domain.Software;

public class OnlineShop {
	
	private static final Logger logger = LoggerFactory.getLogger("c.j.s.i.l.s.OnlineShop");
	
	public static void main(String[] args) {
		/*AbstractApplicationContext applicationContext 
			= new ClassPathXmlApplicationContext("shop.xml",OnlineShop.class);*/
		AbstractApplicationContext applicationContext 
		= new FileSystemXmlApplicationContext("E:/repositories/personal/tracking/Tracking-SpringIntegration/src/main/resources/shop.xml");
		
		Shop shop =(Shop)applicationContext.getBean("shop");
		
		final Order order = createOrder();
		
		logger.debug("*** [OnlineShop] ****");
		
		shop.placedOrder(order);
		
		applicationContext.close();
	}

	private static Order createOrder() {
		Book book = new Book("Of Mice & Men", "Bluebird", new BigDecimal("100"), 1988, "John Steinbeck");
		MusicCD cd = new MusicCD("Off the Wall", "publisher", new BigDecimal("100"), 1975, "Michael Jackson");
		Software macos = new Software("Mavericks", "publisher", new BigDecimal("100"), 2014, "10.9.3");
		
		OrderItem bookItems = new OrderItem(book);
//		bookItems.incrementQuantity();
		
		OrderItem cdItems = new OrderItem(cd);
//		cdItems.incrementQuantity();
//		cdItems.incrementQuantity();
		
		OrderItem swItems = new OrderItem(macos);
		
		final List<OrderItem> orderItems = new ArrayList<OrderItem>();
		orderItems.add(bookItems);
		orderItems.add(cdItems);
		orderItems.add(swItems);
		
		Order order = new Order();
		order.setOrderItems(orderItems);
		logger.debug("Order: " + order);
//		log.debug("Total : "+ order.getTotalCost());

		return order;
		
	}
}
