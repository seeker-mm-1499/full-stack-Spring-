package com.jdc.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import com.jdc.spel.Address;
import com.jdc.spel.Student;

public class UsingRootObject {
	
	ExpressionParser parser;
	@BeforeEach
	void doEach() {
		parser = new SpelExpressionParser();
	}
	@Test
	void testSpel() {
		var student = new Student("Myint Sein", 24, 
				List.of("Java", "Spring", "Angular", "React", "Flutter"));
		var expression = parser.parseExpression("age");
		var result = expression.getValue(student,Integer.class);
		assertEquals(24, result);
		
		var expression1 = parser.parseExpression("interests");
		var result1 = expression1.getValue(student,List.class);
		System.out.println(result1);
		
	}
	@Test
	void using_record() {
		Address address = new Address("Yadanarmyaing Street", "B2/Delta Plaza", "Kamayut");
		
		var expression1 = parser.parseExpression("street");
		var result1 = expression1.getValue(address, String.class);
		System.out.println(result1);
		
		var expression2 = parser.parseExpression("building");
		var result2 = expression2.getValue(address, String.class);
		System.out.println(result2);
		
		var expression3 = parser.parseExpression("township");
		var result3 = expression3.getValue(address, String.class);
		System.out.println(result3);
	}
}
