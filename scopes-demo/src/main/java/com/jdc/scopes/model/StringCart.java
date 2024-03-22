package com.jdc.scopes.model;

import java.util.ArrayList;
import java.util.List;

public class StringCart {
	
	private List<String> list;
	
	public StringCart() {
		list = new ArrayList<>();
	}
	
	public List<String> getList() {
		return list;
	}
	
	public int getCount() {
		return list.size();
	}

	public void add(String data) {
		list.add(data);
	}
}
