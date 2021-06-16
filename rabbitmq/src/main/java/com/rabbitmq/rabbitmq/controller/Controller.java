package com.rabbitmq.rabbitmq.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitmq.rabbitmq.model.Person;

@RestController
@RequestMapping("/api")
public class Controller {
	
	@Autowired
	RabbitTemplate rabbitTemplate;
	
	@GetMapping("/test/{name}")
	public String testAPI(@PathVariable String name) {
		Person p = new Person(1, name, "Hello "+name);
		rabbitTemplate.convertAndSend("Mobile", p); //use the simple msg conveter in need byte array or serializable obj
		return "Success";
	}
				
	
}
