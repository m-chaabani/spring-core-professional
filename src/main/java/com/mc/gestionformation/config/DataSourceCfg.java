package com.mc.gestionformation.config;

import java.sql.Driver;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

@Configuration
@PropertySources({ @PropertySource("classpath:db/db.properties"),
		@PropertySource("classpath:db/hibernate.properties") })
public class DataSourceCfg {

	//db properties
	@Value("${db.driverClassName}")
	private String driverClassName;

	@Value("${db.url}")
	private String url;

	@Value("${db.username}")
	private String username;

	@Value("${db.password}")
	private String password;

	// hibernate properties
	@Value("${hibernate.show_sql}")
	private boolean show_sql;

	@Value("${hibernate.format_sql}")
	private boolean format_sql;

	@Value("${hibernate.dialect}")
	private String dialect;
	
	@Value("${hibernate.hbm2ddl}")
	private String hbm2ddl;



	@Bean
	DataSource datasourceValue() {

		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setUsername(username);
		ds.setPassword(password);
		ds.setUrl(url);
		ds.setDriverClassName(driverClassName);
		return ds;
	}
	
	

	@Bean
	@Primary
	public DataSource dataSource() {
		try {
			
			SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
			Class<? extends Driver> driver = (Class<? extends Driver>) Class.forName(driverClassName);
			dataSource.setDriverClass(driver);
			dataSource.setUrl(url);
			dataSource.setUsername(username);
			dataSource.setPassword(password);
			return dataSource;
		} catch (Exception e) {
			return null;
		}
	}

	@Bean
	@Profile("test")
	DataSource datasourceTest() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		DataSource ds = builder.setType(EmbeddedDatabaseType.H2).addScript("classpath:db/schema_test.sql")
				.addScript("classpath:db/data-test.sql").build();
		return ds;

	}
	
	@Bean
	JdbcTemplate jdbcTempalte() {
		return new JdbcTemplate(dataSource());
	}
	
	@Bean
	NamedParameterJdbcTemplate NamedParamjdbcTempalte() {
		return new NamedParameterJdbcTemplate(dataSource());
	}

	@Bean
	SessionFactory sessionFactory() {
		return new LocalSessionFactoryBuilder(dataSource()).scanPackages("com.mc.gestionformation.model")
				.addProperties(hibernateProperties()).buildSessionFactory();
	}

	@Bean
	public Properties hibernateProperties() {
		Properties hibernateProp = new Properties();
		hibernateProp.put("hibernate.dialect", dialect);
		hibernateProp.put("hibernate.hbm2ddl.auto", hbm2ddl);
		hibernateProp.put("hibernate.format_sql", format_sql);
		hibernateProp.put("hibernate.use_sql_comments", true);
		hibernateProp.put("hibernate.show_sql", show_sql);
		return hibernateProp;
	}

	@Override
	public String toString() {
		return "DataSourceCfg [driverClassName=" + driverClassName + ", url=" + url + ", username=" + username
				+ ", password=" + password + "]";
	}

}
