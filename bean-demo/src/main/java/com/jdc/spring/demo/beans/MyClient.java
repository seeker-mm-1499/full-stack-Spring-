package com.jdc.spring.demo.beans;



import com.jdc.spring.demo.AppBean;

@AppBean
public class MyClient {
	
	public void createClient() {
		System.out.println("This is The test bean.");
	}
	
	public void hello() {
		System.out.println("Hello guys!");
	}

}
