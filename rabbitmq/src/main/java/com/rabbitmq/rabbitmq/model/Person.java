package com.rabbitmq.rabbitmq.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person implements Serializable {

	private long id;
	private String Name;
	private String msg;
	
}
