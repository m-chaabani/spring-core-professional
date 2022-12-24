package com.mc.gestionformation.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mc.gestionformation.dto.FormateurDTO;
import com.mc.gestionformation.model.Formateur;


@Configuration
@ComponentScan(basePackages = "com.mc.gestionformation")
@Import({DataSourceCfg.class,TransactionConfig.class})
@EnableAspectJAutoProxy() // activation de la prise en charge des aspects par ASPECTJ
public class AppConfig {

	Logger logger = LoggerFactory.getLogger(AppConfig.class);
	
	@Bean
	static PropertySourcesPlaceholderConfigurer propertySourcePlaceHolder() {
		return new PropertySourcesPlaceholderConfigurer();
	}


	
}
