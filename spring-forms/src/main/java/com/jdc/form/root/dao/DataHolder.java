package com.jdc.form.root.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.ApplicationScope;

import com.jdc.form.root.dto.UserInput;

@ApplicationScope
@Repository
public class DataHolder {

	private List<UserInput> repoistory;
	
	public DataHolder(){
		repoistory = new ArrayList<>();
	}
	
	public List<UserInput> getAllData(){
		return new  ArrayList<UserInput>(repoistory);
	}

	public void add(UserInput data) {
		repoistory.add(data);
		
	}
}
