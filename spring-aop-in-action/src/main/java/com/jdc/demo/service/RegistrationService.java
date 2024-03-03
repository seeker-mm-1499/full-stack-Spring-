package com.jdc.demo.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.demo.dto.Classes;
import com.jdc.demo.dto.Registration;
import com.jdc.demo.dto.Student;
import com.jdc.demo.repo.RegistrationRepo;
import com.jdc.demo.repo.StudentRepo;

@Service
public class RegistrationService {
	
	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private RegistrationRepo registrationRepo;
	
	public Registration register(Classes classes,Student student, LocalDate date) {
		//create Student
		var regiStudent = studentRepo.create();
		
		return registrationRepo.create(new Registration(0, classes, regiStudent, date));
	}

}
