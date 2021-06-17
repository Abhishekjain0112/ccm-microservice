package com.rabbitmq.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.rabbitmq.rabbitmq.model.Person;

@Service
public class RabbitMQConsumer {

	
	@RabbitListener(queues = {"Mobile","TV"})
	public void getMessage(Person p){
		
		System.out.println("Mix queue"+p);
		
	}
	@RabbitListener(queues = "TV")
	public void getMessageTvQueue(Person p){
		
		System.out.println("TV queue " + p);
		
	}	
	@RabbitListener(queues = "Mobile")
	public void getMessageMobileQueue(Person p){
		
		System.out.println("TV Mobile Queue " + p);
		
	}		
	
	
}
