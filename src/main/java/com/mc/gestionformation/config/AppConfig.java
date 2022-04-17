package com.mc.gestionformation.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.mc.gestionformation.dto.FormateurDTO;
import com.mc.gestionformation.model.Formateur;

//Java Config à partir de Spring 3.0
//FactoryBeanPostProcessor
@Configuration
@ComponentScan(basePackages = "com.mc")
@Import(DataSourceCfg.class)
//@ImportResource(locations = "classpath:spring/applicationContext.xml")
public class AppConfig {

	Logger logger = LoggerFactory.getLogger(AppConfig.class);

	@Autowired
	DataSourceCfg dataSourceCfg;


	@Bean
//	@Profile("test")
	FormateurDTO formateurDto21() {

		FormateurDTO formateurDTO = new FormateurDTO();
		formateurDTO.setFormateur(formateur1());
		return formateurDTO;
	}

	@Bean(name = "formateurDto20")
//	@Profile("production")
	@Scope("prototype")
	@Lazy
	FormateurDTO formateurDto2() {
		FormateurDTO formateurDTO = new FormateurDTO();
		formateurDTO.setFormateur(formateur1());
		return formateurDTO;
	}

	@Bean
	@DependsOn({"formateur1","formateur2"})
	FormateurDTO formateurDto1() {
		FormateurDTO formateurDTO = new FormateurDTO();
		formateurDTO.setFormateur(formateur1());
		return formateurDTO;
	}

	@Bean
	Formateur formateur1() {
		logger.info("Execute method formateur1()");
		Formateur formateur = new Formateur();
		formateur.setPrenom("SALAH");
		formateur.setNom("BEN MOHAMED");
		return formateur;

	}

	@Bean
	Formateur formateur2() {
		logger.info("Execute method formateur2()");
		Formateur formateur = new Formateur();
		formateur.setPrenom("ALI");
		formateur.setNom("BEN MOHAMED");
		return formateur;

	}


}
