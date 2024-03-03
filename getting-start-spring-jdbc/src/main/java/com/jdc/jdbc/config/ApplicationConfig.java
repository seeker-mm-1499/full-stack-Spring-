package com.jdc.jdbc.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

@Configuration
@PropertySource({
	"/database.properties",
	"/sql.properties"
})
@ComponentScan(basePackages = "com.jdc.jdbc")
public class ApplicationConfig {
	@Value("${db.url}")
	private String url;
	@Value("${db.user}")
	private String user;
	@Value("${db.password}")
	private String password;
	
	@Bean
	public DataSource dataSource() {
		var ds = new MysqlConnectionPoolDataSource();
			ds.setUrl(url);
			ds.setUser(user);
			ds.setPassword(password);
		return ds;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource, true);
	}
	
}
