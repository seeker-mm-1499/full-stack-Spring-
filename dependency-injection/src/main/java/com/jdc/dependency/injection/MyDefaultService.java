package com.jdc.dependency.injection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("defaultService")
public class MyDefaultService implements MyService{
	@Override
	public void doWork() {
		System.out.println("Default work done!");
	}
}
