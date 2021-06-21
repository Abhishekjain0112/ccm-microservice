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
		System.out.println(message);
	}

}
