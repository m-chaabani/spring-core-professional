package com.mc.gestionformation.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@PropertySource("classpath:db/db.properties")
public class DataSourceCfg {

	@Value("${db.driverClassName}")
	private String driverClassName;

	@Value("${db.url}")
	private String url;

	@Value("${db.username}")
	private String username;

	@Value("${db.password}")
	private String password;

	@Bean
	static PropertySourcesPlaceholderConfigurer propertySourcePlaceHolder() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	DataSource datasourceValue() {

		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setUsername(username);
		ds.setPassword(password);
		ds.setUrl(url);
		ds.setDriverClassName(driverClassName);
		return ds;
	}

//	@Bean
//	@Profile("prod")
//	public DataSource dataSource() {
//		try {
//			DataSource dataSource = new SimpleDriverDataSource();
//			Class<? extends Driver> driver = (Class<? extends Driver>) Class.forName(driverClassName);
//			dataSource.setDriverClass(driver);
//			dataSource.setUrl(url);
//			dataSource.setUsername(username);
//			dataSource.setPassword(password);
//			DatabasePopulatorUtils.execute(databasePopulator(), dataSource);
//			return dataSource;
//		} catch (Exception e) {
//			return null;
//		}
//	}

	@Bean
	@Profile("test")
	DataSource datasourceTest() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		DataSource ds = builder.setType(EmbeddedDatabaseType.H2).addScript("classpath:db/schema_test.sql")
				.addScript("classpath:db/data-test.sql").build();
		return ds;

	}

	@Override
	public String toString() {
		return "DataSourceCfg [driverClassName=" + driverClassName + ", url=" + url + ", username=" + username
				+ ", password=" + password + "]";
	}

}
