package com.mc.gestionformation.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

@Configuration
@PropertySources({ @PropertySource("classpath:db/db.properties"),
		@PropertySource("classpath:db/hibernate.properties") })

public class DataSourceCfg {

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
	private String show_sql;

	@Value("${db.url}")
	private String format_sql;

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
	DataSource datasourceTest() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		DataSource ds = builder.setType(EmbeddedDatabaseType.H2).addScript("classpath:db/schema_test.sql")
				.addScript("classpath:db/data-test.sql").build();
		return ds;

	}

	@Bean
	SessionFactory sessionFactory() {
		return new LocalSessionFactoryBuilder(datasourceTest())
				.scanPackages("com.mc.gestionformation.model")
				.addProperties(hibernateProps()).buildSessionFactory();
	}

	@Bean
	Properties hibernateProps() {

		Properties props = new Properties();
		props.put("hibernate.show_sql", true);
		props.put("hibernate.format_sql", true);
		props.put("hibernate.hbm2ddl.auto", "create");
		// props.put("hibernate.dialect", "H2_DIA);
		return props;
	}

	@Override
	public String toString() {
		return "DataSourceCfg [driverClassName=" + driverClassName + ", url=" + url + ", username=" + username
				+ ", password=" + password + "]";
	}

}
