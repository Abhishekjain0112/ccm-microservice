package com.rabbitmq.priorityconsumer.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageListener {

	/**
	 * Processing messages
	 */
	@RabbitListener(queues = "priority-queue")
	public void listen(String message) {
		
		if(message.equalsIgnoreCase("Hello Abhishek this is priority Queue MSG: abhi")) {
			throw new RuntimeException();
		}
		System.out.println(message);
	}

	@RabbitListener(queues = "deadLetter.queue")
	public void DeadLeaterlisten(String message) {
		
		System.out.println("***This is in Dead Letter Queue ***" + message);
	}

	
	
	
	
	
}
