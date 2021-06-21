package com.rabbitmq.rabbitmqcode.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.rabbitmq.rabbitmqcode.configuration.MessageConfiguration;
import com.rabbitmq.rabbitmqcode.dto.OrderStatus;

@Component
public class UserConsumer {

	
	
	@RabbitListener(queues = MessageConfiguration.QUEUE)
	public void consumeMessageFromQueue(OrderStatus orderStatus) {
		
		System.out.println("Message reviced form the queue : "+ orderStatus);
	}
	  
	
}
