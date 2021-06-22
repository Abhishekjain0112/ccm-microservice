package com.rabbitmq.rabbitmqcode.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Abhishek
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order {

	private String orderId;
	private String name;
	private int qty;
	private double price;
	
	
}