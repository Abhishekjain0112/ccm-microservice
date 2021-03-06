package com.rabbitmq.priorityproducer.configuration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfiguration {

	private static final String EXCHANGE = "priority-exchange";

	public static final String QUEUE = "priority-queue";

	private static final String ROUTING_KEY = "priority.queue.#";

	/**
	 * Define priority queues
	 */
	@Bean
	Queue queue() {
		Map<String, Object> args = new HashMap<>();
		args.put("x-max-priority", 100);
		args.put("x-dead-letter-exchange", "deadLetterExchange");
		args.put("x-dead-letter-routing-key", "dlrkey");
		return new Queue(QUEUE, false, false, false, args);
	}

	/**
	 * Define the switch
	 */
	@Bean
	TopicExchange exchange() {
		return new TopicExchange(EXCHANGE);
	}

	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
	}

	
	
	/**
	 * Dead Letter Queue
	 * @return
	 */
	@Bean
	Queue dlq() {
		return QueueBuilder.durable("deadLetter.queue").build();
	}

	
	/**
	 * Dead Letter Exchange
	 * @return
	 */
	@Bean
	DirectExchange deadLetterExchange() {
		return new DirectExchange("deadLetterExchange");
	}

	/**
	 * Dead Letter Binding
	 * 
	 * @return
	 */
	@Bean
	Binding DLQbinding() {
		return BindingBuilder.bind(dlq()).to(deadLetterExchange()).with("dlrkey");
	}

}
