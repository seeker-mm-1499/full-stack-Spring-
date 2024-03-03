package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.product.config.AppConfig;
import com.jdc.product.model.dao.CategoryDao;
import com.jdc.product.model.dto.Category;

@TestMethodOrder(OrderAnnotation.class)
@SpringJUnitConfig(classes = AppConfig.class)
public class CategoryTest {
	
	@Autowired
	private CategoryDao dao;

	
	@Test
	@Order(1)
	@DisplayName("1.Create Category")
	void test() {
		var c= new Category();
			c.setName("Foods");
			var id = dao.create(c);
			assertEquals(1, id);
	}
	
	
	@Test
	@Order(2)
	@DisplayName("2.Update Category ")
	void test2() {
		var c = new Category();
			c.setId(1);
			c.setName("Drinks");
			int	count = dao.update(c);
			assertEquals(1, count);
	}
	
	@Test
	@Order(3)
	@DisplayName("3.Find Category by Id")
	void test3() {
		Category c = dao.findById(1);
		assertEquals("Drinks", c.getName());
	}
	@Test
	@Order(4)
	@DisplayName("4. Find Category by Name like")
	void test4() {
		List<Category> list = dao.findByNameLike("Drin");
		assertEquals(1,list.size());
	}
	
	@Test
	@Order(5)
	@DisplayName("5. Find count by Name like")
	void test5() {
		int count = dao.findCountByNameLike("drink%");
		assertEquals(1, count);
	}
	
	@Test
	@Order(6)
	@DisplayName("6. Delete by Id")
	void test6() {
		int count = dao.deleteById(1);
		assertEquals(1, count);
	}
}
