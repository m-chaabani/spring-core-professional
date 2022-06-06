package com.mc.gestionformation.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.mc.gestionformation.integration.dao.FormateurDAOJdbcTemplate;

@Configuration
@ComponentScan(basePackageClasses = FormateurDAOJdbcTemplate.class )
public class JdbcConfigTest {
	
	@Bean
	JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate( dataSource() );
	}
	
	@Bean
	NamedParameterJdbcTemplate namedJdbcTemplate() {
		return new NamedParameterJdbcTemplate( dataSource() );
	}
	
	
	@Bean
	DataSource dataSource() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase ds = builder.setType(EmbeddedDatabaseType.H2)
				                     .generateUniqueName(true)
				                     .addScript("classpath:db/jdbctemplate/schema-test-jt.sql")
				                     .addScript("classpath:db/jdbctemplate/data-test-jt.sql")
				                     .build();
		return ds;
	}

}
