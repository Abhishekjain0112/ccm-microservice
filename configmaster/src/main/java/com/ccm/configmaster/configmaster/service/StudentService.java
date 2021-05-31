package com.ccm.configmaster.configmaster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccm.configmaster.configmaster.model.Student;
import com.ccm.configmaster.configmaster.repository.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo studentRepo;
	
	
	public Student add(Student s) {
     	return studentRepo.save(s);
	}
	
}
