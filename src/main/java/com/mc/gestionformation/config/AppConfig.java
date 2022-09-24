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
@ComponentScan(basePackages = "com.mc")
@Import({DataSourceCfg.class,TransactionConfig.class})
@EnableAspectJAutoProxy() // activation de la prise en charge des aspects par ASPECTJ
public class AppConfig {

	Logger logger = LoggerFactory.getLogger(AppConfig.class);
	
	@Bean
	static PropertySourcesPlaceholderConfigurer propertySourcePlaceHolder() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Autowired
	DataSourceCfg dataSourceCfg;
	

	
	@Bean(name = "formateurDto1")
	FormateurDTO formateurDto2() {
		FormateurDTO formateurDTO = new FormateurDTO();
		formateurDTO.setEntity(formateur1());
		return formateurDTO;
	}


	@Bean
	Formateur formateur1() {
		logger.info("Execute method formateur1()");
		Formateur formateur = new Formateur();
		formateur.setId(1L);
		formateur.setPrenom("SALAH");
		formateur.setNom("BEN MOHAMED");
		return formateur;

	}

}
