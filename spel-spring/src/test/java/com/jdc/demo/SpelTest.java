package com.jdc.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class SpelTest {
	
	ExpressionParser parser;
	
	@BeforeEach
	void doEach() {
		parser = new SpelExpressionParser();
	}

	@Test
	void test() {
		
		var expression = parser.parseExpression("10+5");
		
		var result = expression.getValue(Integer.class);
		System.out.println(result);
		assertEquals(15, result);
	}
	@Test
	void demo() {
		var expression = parser.parseExpression("{1,2,3,4,5}");
		var result = expression.getValue(List.class);
		System.out.println(result);
		assertEquals(5, result.size());
		
		
	}
	
}
