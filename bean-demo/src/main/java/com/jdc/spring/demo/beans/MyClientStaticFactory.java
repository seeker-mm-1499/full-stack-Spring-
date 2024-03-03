package com.jdc.spring.demo.beans;

public class MyClientStaticFactory {
	
	public static MyClient create() {
		return new MyClient();
	}

}
