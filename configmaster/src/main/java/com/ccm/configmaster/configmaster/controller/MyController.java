package com.ccm.configmaster.configmaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ccm.configmaster.configmaster.model.Student;
import com.ccm.configmaster.configmaster.service.StudentService;

@RestController
public class MyController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/get111/{name}")
	public String getName(@PathVariable String name){
		return "Hello "+ name.toUpperCase() +" Welcome to the spring project";
	}
	

	@GetMapping("/save/{id}")
	public Student add(@PathVariable int id){
		   
		return studentService.add(new Student(id, "Abhi", "Indore"));
		
	}
	
	
	
	
	
}
