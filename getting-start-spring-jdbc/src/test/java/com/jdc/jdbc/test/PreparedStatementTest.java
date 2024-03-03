package com.jdc.jdbc.test;

import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.jdbc.config.ApplicationConfig;
import com.jdc.jdbc.dto.Member;
import com.jdc.jdbc.facotry.MapRow;

@TestMethodOrder(OrderAnnotation.class)
@SpringJUnitConfig(classes = ApplicationConfig.class)
public class PreparedStatementTest {

	@Autowired
	private JdbcOperations jdbcOperations;

	@Autowired
	private MapRow rowmapper;

	@Value("${member.insert}")
	String sql;

	@Test
	@Order(1)
	@DisplayName("1. Display Property Sql")
	@Sql(scripts = "/database.sql")
	void test1() {
		System.out.println(sql);
	}

	@Test
	@Order(2)
	@DisplayName("2. Execute with Creator")
	@Sql(scripts = "/database.sql")
	void test2() {
		var creator = new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				var stmt = con.prepareStatement(sql);
				stmt.setString(1, "user1");
				stmt.setString(2, "user00");
				stmt.setString(3, "Myae Khin");
				stmt.setString(4, "09451278411");
				stmt.setString(5, "myaekhin@gmail.com");
				return stmt;
			}
		};
		var count = jdbcOperations.execute(creator, PreparedStatement::executeUpdate);
		assertEquals(1, count);
	}

	@Test
	@Order(3)
	@DisplayName("3. Execute with PreparedStatementCreatorFactory")
	void test3(@Qualifier("memberInsert") PreparedStatementCreatorFactory factory) {
		var creator = factory.newPreparedStatementCreator(
				List.of("admin", "admin", "Myint Sein", "09451201145", "myintsein@gmail.com"));
		var count = jdbcOperations.execute(creator, PreparedStatement::executeUpdate);
		assertEquals(1, count);
	}

	@Test
	@Order(4)
	@DisplayName("4. Update with PreparedStatementCreatorFactory")
	void test4(@Qualifier("memberInsert") PreparedStatementCreatorFactory factory) {
		var creator = factory.newPreparedStatementCreator(
				List.of("user2", "user002", "Moe Chan", "09788451265", "moechan@gmail.com"));
		var count = jdbcOperations.update(creator);
		assertEquals(1, count);
	}

	@Test
	@Order(5)
	@DisplayName("5. Execut with Creator for select stmt")
	void Test(@Qualifier("memberSelectByName") PreparedStatementCreatorFactory factory) {
		var result = jdbcOperations.execute(factory.newPreparedStatementCreator(List.of("myint sein%")), stmt -> {
			List<Member> list = new ArrayList<Member>();
			var rs = stmt.executeQuery();
			while (rs.next()) {
				var m = new Member(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				list.add(m);
			}
			return list;
		});
		assertEquals(1, result.size());
		System.out.println(result);
		/*
		 * for(Member m : result) { System.out.println(m.getLoginId());
		 * System.out.println(m.getPassword()); System.out.println(m.getName());
		 * System.out.println(m.getPhone()); System.out.println(m.getEmail()); }
		 */
	}

	@Test
	@Order(6)
	@DisplayName("6. Query using rowmapper with Creator for select stmt")
	void Test6(@Qualifier("memberSelectByName") PreparedStatementCreatorFactory factory) {
		var result = jdbcOperations.query(factory.newPreparedStatementCreator(List.of("myae khin")), rowmapper);
		System.out.println(result);

		for (Member m : result) {
			System.out.println(m.getLoginId());
			System.out.println(m.getPassword());
			System.out.println(m.getName());
			System.out.println(m.getPhone());
			System.out.println(m.getEmail());
		}

	}

	@Test
	@Order(7)
	@DisplayName("7. Execute with prepared Statement")
	void test7(@Value("${member.insert}") String sql) {
		var count = jdbcOperations.execute(sql, (PreparedStatement stmt) -> {
			stmt.setString(1, "user3");
			stmt.setString(2, "user003");
			stmt.setString(3, "Leo");
			stmt.setString(4, "0945102153");
			stmt.setString(5, "leo@gmail.com");

			return stmt.executeUpdate();
		});
		assertEquals(1, count);
	}

	@Test
	@Order(8)
	@DisplayName("8. Update with prepared Statement Setter")
	void test8(@Value("${member.insert}") String sql) {
		var count = jdbcOperations.update(sql, stmt -> {
			stmt.setString(1, "user4");
			stmt.setString(2, "user004");
			stmt.setString(3, "Leo Leo");
			stmt.setString(4, "0945785153");
			stmt.setString(5, "leoleo@gmail.com");
		});
		assertEquals(1, count);
	}

	@Test
	@Order(9)
	@DisplayName("9. Update with Params")
	void test9(@Value("${member.insert}") String sql) {
		int count = jdbcOperations.update(sql, "user5", "user005", "Myint Oo", "09451254789", "myintoo@gmial.com");
		assertEquals(1, count);
	}

	@Test
	@Order(10)
	@DisplayName("10. Query with rowmapper and parmams")
	void test10(@Value("${member.select}") String sql) {
		var count = jdbcOperations.query(sql, rowmapper, "myint sein%");
		assertEquals(1, count.size());
	}

	@Test
	@Order(11)
	@DisplayName("11. Query with rowmapper and parmams")
	void test11(@Value("${member.select}") String sql) {
		var count = jdbcOperations.query(sql, rowmapper, "leo%");
		assertEquals(2, count.size());
	}


@Test
@Order(12)
@DisplayName("12.Query with result set extractor")
void test12() {
	var count = jdbcOperations.query("select * from member where loginId like ?", stmt->stmt.setString(1, "Admin%"), rs->{
	while(rs.next()) {
		return rowmapper.mapRow(rs, 1);
	}
		return null;
	});
	System.out.println(count.getName());
}
@Test
@Order(13)
@DisplayName("13.Query for object with row mapper")
void test13() {
	var count = jdbcOperations.queryForObject("select * from member where loginId like ?",
			rowmapper, "admiN%");
	assertEquals("myintsein@gmail.com", count.getEmail());
}
}