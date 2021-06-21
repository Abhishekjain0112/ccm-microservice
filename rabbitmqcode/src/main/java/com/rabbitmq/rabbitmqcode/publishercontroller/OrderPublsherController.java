package com.rabbitmq.rabbitmqcode.publishercontroller;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitmq.rabbitmqcode.configuration.MessageConfiguration;
import com.rabbitmq.rabbitmqcode.dto.Order;
import com.rabbitmq.rabbitmqcode.dto.OrderStatus;

@RestController
@RequestMapping("/order")
public class OrderPublsherController {

	@Autowired
	private RabbitTemplate template;

	
	@PostMapping("/{resturantName}")
	public String bookOrder(@RequestBody Order order, @PathVariable  String resturantName) {
		
		order.setOrderId(UUID.randomUUID().toString());
		
		
		OrderStatus orderStatus = new OrderStatus(order, "PROCESS", "Your order is placed succesfully in " + resturantName);
		template.convertAndSend(MessageConfiguration.EXCHANGE, MessageConfiguration.ROUTING_KEY, orderStatus);
		return "Success!!";
		//request will go to different service before that i have to notify the user 
	}
	
}
