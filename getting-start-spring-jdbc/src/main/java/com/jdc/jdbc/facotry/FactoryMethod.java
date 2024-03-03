package com.jdc.jdbc.facotry;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;

@Configuration
public class FactoryMethod {
	

	@Bean
	@Qualifier("memberInsert")
	public PreparedStatementCreatorFactory createPreparedStatementCreatorFactory(
			@Value("${member.insert}") String sql) {
		return  new PreparedStatementCreatorFactory(sql, new int[] {
				Types.VARCHAR,
				Types.VARCHAR,
				Types.VARCHAR,
				Types.VARCHAR,
				Types.VARCHAR
		});
	}
	
	@Bean
	@Qualifier("memberSelectByName")
	public PreparedStatementCreatorFactory createPreparedStatementCreatorFactoryFindByName(
			@Value("${member.select}") String sql) {
		return  new PreparedStatementCreatorFactory(sql, new int[] {
				Types.VARCHAR
		});
	}
	
	
}
