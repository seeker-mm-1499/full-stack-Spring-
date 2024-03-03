package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.product.config.AppConfig;
import com.jdc.product.model.dao.CategoryDao;
import com.jdc.product.model.dao.ProductDao;
import com.jdc.product.model.dto.Product;

@TestMethodOrder(OrderAnnotation.class)
@SpringJUnitConfig(classes = AppConfig.class)
public class ProductDaoTest {

	@Autowired
	private ProductDao dao;
	
	@Autowired
	private CategoryDao categories;
	
	@Test
	@Order(1)
	@Sql(statements = {
			"insert into category(name) values ('Foods')",
			"insert into category(name) values ('Drinks')"
	})
	@DisplayName("1. create with params")
	void test1() {
		var category = categories.findById(1);
		var p = new Product();
		p.setName("Pillow Pan");
		p.setPrice(600);
		p.setCategory(category);
		
		var id= dao.create(p);
		assertEquals(1, id);
		assertEquals("Foods",category.getName());
	}
	
	@Test
	@Order(2)
	@DisplayName("2.Find Product By Id")
	void test2() {
		Product p = dao.findById(1);
		assertEquals("Pillow Pan", p.getName());
		assertEquals(600, p.getPrice());
		assertEquals(1, p.getCategory().getId());
		assertEquals("Foods", p.getCategory().getName());
		
		assertNull(dao.findById(2));
		
	}
	@Test
	@Order(3)
	@DisplayName("3.Find Product By Category")
	void test3() {
		List<Product> list = dao.findByCategoryId(1);
		
		assertEquals(1, list.size());
		assertTrue(dao.findByCategoryId(2).isEmpty());
	}
	@Test
	@Order(4)
	@DisplayName("4.Search")
	void test4() {
		List<Product> list = dao.search("Foods");
		assertEquals(1, list.size());
		
		assertEquals(1, dao.search("piLlow").size());
		assertTrue(dao.search("Pillows").isEmpty());
	}
	@Test
	@Order(5)
	@DisplayName("5. Update Product")
	void test5() {
		var p = dao.findById(1);
		p.setName("Pillow Bread");
		p.setPrice(700);
		
		int count = dao.update(p);
		assertEquals(1, count);
		
		var other = dao.findById(1);
		assertEquals( other.getName(),p.getName());
		assertEquals(other.getPrice(), p.getPrice());

	}
	@Test
	@Order(6)
	@DisplayName("6. Delete Product")
	void test6() {
		int count = dao.deleteById(1);
		assertEquals(1, count);
		assertTrue(dao.findByCategoryId(1).isEmpty());
		
	}
}
