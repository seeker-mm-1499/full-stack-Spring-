package com.jdc.dependency.injection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("customService")
public class MyCustomService implements MyService {
	@Override
	public void doWork() {
		System.out.println("Custom work done!");
	}
}
