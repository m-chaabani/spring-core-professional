package com.mc.gestionformation.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
public class TransactionConfig {


	
	
	@Bean
	PlatformTransactionManager jpaTransactionManager(EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
	
	@Bean
	@Primary
	PlatformTransactionManager hibernateTransactionManager(SessionFactory sessionFactory) {
		return new HibernateTransactionManager(sessionFactory);
	}
	
	@Bean
	PlatformTransactionManager dataSourceTransactionManager(DataSource datasource) {
		return new DataSourceTransactionManager(datasource);
	}
	
	@Bean
	PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}
