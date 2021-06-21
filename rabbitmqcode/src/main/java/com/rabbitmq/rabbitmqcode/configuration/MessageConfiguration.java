package com.rabbitmq.rabbitmqcode.configuration;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Abhishek
 *
 */
@Configuration
public class MessageConfiguration {

	public static final String ROUTING_KEY = "java_routingKey";
	public static final String EXCHANGE = "java_exchange";
	public static final String QUEUE = "java_Queue";

	/**
	 * Create Queue
	 * 
	 * @return Queue
	 */
	@Bean
	public Queue queue() {
		return new Queue(QUEUE);
	}

	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(EXCHANGE);
	}

	@Bean
	public Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder
				.bind(queue)
				.to(exchange)
				.with(ROUTING_KEY);
	}

	@Bean
	public MessageConverter convetor() {
		return new Jackson2JsonMessageConverter();
	}

	public AmqpTemplate template(ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(convetor());
		return rabbitTemplate;

	}

}
