package com.rabbitmq.priorityproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitmq.priorityproducer.sendmessage.MessageSender;

/**
 * @author abhi
 *
 */
@RestController
@RequestMapping("/send")
public class Controller {

	@Autowired
	private MessageSender messageSender;

	/**
	 * Set Message and Priority Number in the priority queue
	 * 
	 * @param msg
	 * @param priority
	 * @return
	 */
	@GetMapping("/{msg}/{priority}")
	public String sendMsg(@PathVariable String msg, @PathVariable int priority) {

		messageSender.sendPriorityMessage(msg, priority);
		return "Successfuly added in the priorityQueue";

	}

}
