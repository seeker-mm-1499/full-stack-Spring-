package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.product.config.AppConfig;
import com.jdc.product.model.dto.Category;

@SpringJUnitConfig(classes = AppConfig.class)
@TestMethodOrder(OrderAnnotation.class)
public class MemberDaoTest {

	@Autowired
	private JdbcOperations jdbcOperations;
	
	@Test
	@DisplayName("1.Update using embedded db")
	@Order(1)
	void test1() {
		List<Object []> params = new ArrayList<Object[]>();
		params.add(new Object[] {"Food"});
		params.add(new Object[] {"Drinks"});		 
		params.add(new Object[] {"Electronics"});
		params.add(new Object[] {"Fashion"});
		params.add(new Object[] {"Accessory"});
		
		var count =jdbcOperations.batchUpdate("insert into category(name) values (?)", params);
		assertEquals(5, count.length);
	
	}
	@Test
	@DisplayName("2.Query method")
	@Order(2)
	void test2() {
		var list = jdbcOperations.query("select * from category",
				new BeanPropertyRowMapper<Category>(Category.class));
		System.out.println(list);
	}
}
