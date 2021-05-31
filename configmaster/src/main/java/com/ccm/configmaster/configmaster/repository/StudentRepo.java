package com.ccm.configmaster.configmaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ccm.configmaster.configmaster.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

}
