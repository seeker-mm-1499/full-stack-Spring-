package com.jdc.demo;

public class BusinessClass implements BusinessInterface {

	@Override
	public void doBusiness(String ... names) {
		System.out.println("Business Logics.");
	}

}
