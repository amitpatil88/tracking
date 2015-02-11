package com.javahelp.spring.integration.labs.services;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.javahelp.spring.integration.labs.domain.Book;
import com.javahelp.spring.integration.labs.domain.MusicCD;
import com.javahelp.spring.integration.labs.domain.OrderItem;
import com.javahelp.spring.integration.labs.domain.Software;

public class Shopkeeper {
	private static final Logger logger = LoggerFactory.getLogger("c.j.s.i.l.s.Shopkeeper");
	
	private static final BigDecimal BOOK_DISCOUNT = BigDecimal.valueOf(0.05);
	private static final BigDecimal MUSIC_DISCOUNT = BigDecimal.valueOf(0.10);
	private static final BigDecimal SOFTWARE_DISCOUNT = BigDecimal.valueOf(0.15);
	
	/**
	 * Perform discount on books
	 * @param orderItem
	 * @return OrderItem with discount price newly calculated
	 */
	public OrderItem processBooks(OrderItem bookOrderItem){
		logger.debug("*** [Shopkeeper] processing book : "+ bookOrderItem.getItem().getTitle() +" ****");
		
		final BigDecimal finalPrice = calculateDiscountedPrice(bookOrderItem, BOOK_DISCOUNT);
		
		bookOrderItem.setDiscountedPrice(finalPrice);
		
		return bookOrderItem;
		
	}

	/**
	 * Perform discount on books
	 * @param orderItem
	 * @return OrderItem with discount price newly calculated
	 */
	public OrderItem processMusic(OrderItem musicOrderItem){
		logger.debug("*** [Shopkeeper] processing book : "+ musicOrderItem.getItem().getTitle() +" ****");
		
		final BigDecimal finalPrice = calculateDiscountedPrice(musicOrderItem, MUSIC_DISCOUNT);
		musicOrderItem.setDiscountedPrice(finalPrice);
		
		return musicOrderItem;
	}

	/**
	 * Perform discount on books
	 * @param orderItem
	 * @return OrderItem with discount price newly calculated
	 */
	public OrderItem processSoftwares(OrderItem softwareOrderItem) {
		logger.debug("*** [Shopkeeper] processing book : "+ softwareOrderItem.getItem().getTitle() +" ****");
		
		final BigDecimal finalPrice = calculateDiscountedPrice(softwareOrderItem, SOFTWARE_DISCOUNT);
		
		softwareOrderItem.setDiscountedPrice(finalPrice);
		
		return softwareOrderItem;
	}
	
	/*
	 * Computes the new discounted price for an item
	 * @param orderItem the item of interest
	 * @param discount The amount to be discounted.
	 */
	public BigDecimal calculateDiscountedPrice(final OrderItem orderItem, final BigDecimal discount){
		final BigDecimal discountedPrice = round(orderItem.getTotalPrice().multiply(discount));
		final BigDecimal finalPrice = round(orderItem.getTotalPrice().subtract(discountedPrice));
		
		logger.debug("item (" + getItemType(orderItem) + ") " +  
				"item price: " + orderItem.getItem().getPrice() +
				" discount: " + discountedPrice +
				" final price: " + finalPrice);
		
		return finalPrice;
	}
	
	public String getItemType(final OrderItem orderItem) {
		String type = "";
		
		if(orderItem.getItem() instanceof Book) {
			
			type = "Book:" + orderItem.getItem().getTitle();
			
		} else if(orderItem.getItem() instanceof MusicCD){
			
			type = "MusicCD:" + orderItem.getItem().getTitle();
			
		} else if(orderItem.getItem() instanceof Software){
			
			type = "Software :"+ orderItem.getItem().getTitle();
			
		}
		
		return type;
	}
	
	
	private BigDecimal round(final BigDecimal value){
		
		return value.setScale(2,BigDecimal.ROUND_HALF_EVEN);
		
	}
	
}
