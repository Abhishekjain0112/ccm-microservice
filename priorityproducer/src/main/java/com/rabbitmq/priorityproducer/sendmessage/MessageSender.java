package com.rabbitmq.priorityproducer.sendmessage;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

	
	private static final String EXCHANGE = "priority-exchange";

	private static final String ROUTING_KEY_PREFIX = "priority.queue.";
	@Autowired
	private RabbitTemplate rabbitTemplate;

	/**
	   * Send a message with priority setting
	 *
	   * @param priority priority
	 */
	public void sendPriorityMessage(String content, Integer priority) {
	    rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY_PREFIX + "test", "Hello Abhishek this is priority Queue MSG: " + content,
	            message -> {
	                message.getMessageProperties().setPriority(priority);
	                //if(priority>100) {throw new RuntimeException();}
	                return message;
	            });
	}

	
}
