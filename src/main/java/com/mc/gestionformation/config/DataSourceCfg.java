package com.mc.gestionformation.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

//db.username=admin
//db.password=admin
//db.url=jdbc:h2:./db/formationDB
//db.driverClassName=

@Configuration
@PropertySource("classpath:db/db.properties")
public class DataSourceCfg {
// BY @VALUE
	@Value("${db.driverClassName}") //	@Value("org.h2.Driver")
	private String driverClassName;

	@Value("${db.url}")
	private String url;

	@Value("${db.username}")
	private String username;

	@Value("${db.password}")
	private String password;
	// BY @VALUE
	
//	OU BIEN 
	
	// BY Environment 
	@Autowired
	private Environment environment;
	// BY Environment 
	

	// A faire pour la séance prochaine
	// 1. Fichier properties pour les parametres de la DB
	// 2. XML et JAVA_CONFIG propertyHolderConfiguerer
	// 3. @PropertySource, @Value, Environement

	@Bean
	static PropertySourcesPlaceholderConfigurer propertySourcePlaceHolder() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	

	@Bean("dataSourceByValue")
	//@Profile("ShowByValue")
	DataSource datasourceValue() {

		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setUsername(username);
		ds.setPassword(password);
		ds.setUrl(url);
		ds.setDriverClassName(driverClassName);
		return ds;
	}
	
	@Bean("dataSourceByEnv")
	DataSource datasourceEnv() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setUsername( environment.getProperty("db.username") );
		ds.setPassword(environment.getProperty("db.password") );
		ds.setUrl(environment.getProperty("db.url") );
		ds.setDriverClassName(environment.getProperty("db.driverClassName") );
		return ds;
	}

	@Configuration
	@Profile("production")
	static class ProductionDataSourceCfg {

		private String driveClassName;
		private String url;
		private String username;
		private String password;

		@Bean
		DataSource datasource() {
			return null;
		}

	}
	
	void m() {
		
		//no sens
		@Configuration
		class localCnfigClass {
			
		}
		
	}

	@Configuration
	@Profile("dev")
	static class DevDataSourceCfg {

		private String driveClassName;
		private String url;
		private String username;
		private String password;

		@Bean
		DataSource datasource() {
			return null;
		}

	}

	@Override
	public String toString() {
		return "DataSourceCfg [driverClassName=" + driverClassName + ", url=" + url + ", username=" + username
				+ ", password=" + password + "]";
	}

}
