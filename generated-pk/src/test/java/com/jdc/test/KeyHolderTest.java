package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.product.config.AppConfig;
import com.jdc.product.model.dao.CategoryDao;
import com.jdc.product.model.dto.Category;

@TestMethodOrder(OrderAnnotation.class)
@SpringJUnitConfig(classes = AppConfig.class)
public class KeyHolderTest {
	
	@Autowired
	private CategoryDao dao;
	
	
	@Test
	@Order(1)
	void test1() {
		var c = new Category();
		c.setName("Foods");
		
		var id = dao.create(c);
		assertEquals(1, id);
		
	}

}
