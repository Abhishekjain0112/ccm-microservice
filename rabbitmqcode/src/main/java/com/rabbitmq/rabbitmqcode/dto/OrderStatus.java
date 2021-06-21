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
public class OrderStatus {

	private Order order;
	private String status;// process, completed status
	private String message;

}
