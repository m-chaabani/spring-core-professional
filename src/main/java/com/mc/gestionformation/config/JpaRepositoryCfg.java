package com.mc.gestionformation.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
public class JpaRepositoryCfg {

	@Bean
	@Primary
	EntityManagerFactory entityManagerFactory(DataSource datasource, Properties hibernateProperties) {
		
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(datasource);
		entityManagerFactoryBean.setPackagesToScan("com.mc.gestionformation.model");
		entityManagerFactoryBean.setPersistenceProvider(new HibernatePersistenceProvider());
		entityManagerFactoryBean.setJpaProperties(hibernateProperties);
		entityManagerFactoryBean.afterPropertiesSet();
		
		
		return entityManagerFactoryBean.getNativeEntityManagerFactory();
	}
	
	

}
