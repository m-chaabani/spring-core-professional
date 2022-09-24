package com.mc.gestionformation.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.mc.gestionformation.integration.dao.springdata",
         transactionManagerRef = "jpaTransactionManager" )
public class SpringDataConfig {

}
