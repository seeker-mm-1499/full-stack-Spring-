package com.jdc.demo.service;

import org.springframework.stereotype.Service;

import com.jdc.demo.dto.Student;

@Service
public class DemoService {

	public void doBusiness() {
		System.out.println("This is a void method without argument.");

	}
	public Student getStudent() {
		return new Student(1, "Myint Sein", "09442065638", "myintsein1999.mm9@gmial.com");
	}
	public int divided(int a,int b) {
		System.out.println("This is division.");
		return a/b;
	}
}
