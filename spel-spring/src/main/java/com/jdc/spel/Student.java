package com.jdc.spel;

import java.util.List;

public class Student {
	
	private String name;
	private int age;
	private List<String> interests;
	
	public Student(String name, int age,List<String> interests) {
		this.name= name;
		this.age=age;
		this.interests=interests;
	}
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public List<String> getInterests() {
		return interests;
	}

}
