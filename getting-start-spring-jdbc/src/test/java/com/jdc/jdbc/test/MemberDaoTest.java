package com.jdc.jdbc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.Statement;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.jdbc.config.ApplicationConfig;
import com.jdc.jdbc.dao.MemberDao;
import com.jdc.jdbc.dto.Member;

@SpringJUnitConfig(classes = ApplicationConfig.class)
@TestMethodOrder(OrderAnnotation.class)
public class MemberDaoTest {

	@Autowired
	private MemberDao memberDao;

	@Autowired
	private JdbcOperations jdbcOperations;

	@Test
	@Sql(scripts = "/database.sql")
	@Order(1)
	void test() {
		Member m = new Member("admin", "myintsein", "Myint Sein", null, null);
		memberDao.create(m);
	}

	@Test
	@Order(2)
	void testUsingConnection() {
		var data = jdbcOperations.execute((Connection conn) -> {
			var stmt = conn.createStatement();
			var rs = stmt.executeQuery("select count(*) from member");
			while (rs.next()) {
				return rs.getLong(1);
			}
			return 0;
		});
		assertEquals(1L, data);
	}

	@Test
	@Order(3)
	void testUsingStatement() {
		var data = jdbcOperations.execute((Statement stmt) -> {
			return stmt.executeUpdate("""
					insert into member values (
					'member',
					'member',
					'Moe Chan',
					'09-751559415',
					'moechan@gmail.com')
					""");

		});
		assertEquals(1, data);
	}

	@Test
	@Order(4)
	void testStaticQueryRowExtractor() {
		var result = jdbcOperations.query("select count(*) from member", rse -> {
			while (rse.next()) {
				return rse.getInt(1);
			}
			return null;
		});
		assertEquals(2, result);

	}
	@Test
	@Order(5)
	void testStaticSqlWithQueryForObject() {
		var m = jdbcOperations.queryForObject("select name from member where loginId='admin'",
				String.class);
		System.out.println(m);
	}
}