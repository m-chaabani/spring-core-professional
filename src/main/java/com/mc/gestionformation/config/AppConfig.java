package com.mc.gestionformation.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.annotation.AliasFor;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.mc.gestionformation.dto.FormateurDTO;
import com.mc.gestionformation.model.Formateur;


@Configuration
@ComponentScan(basePackages = "com.mc.gestionformation")
public class AppConfig {

	Logger logger = LoggerFactory.getLogger(AppConfig.class);
	
	@Bean(initMethod = "init", destroyMethod = "destroy")
	FormateurDTO formateurDto() {
		FormateurDTO formateurDTO = new FormateurDTO();
		formateurDTO.setFormateur(formateur());
		return formateurDTO;
	}
	
	@Bean
	FormateurDTO formateurDtoSansInit() {
		FormateurDTO formateurDTO = new FormateurDTO();
		formateurDTO.setFormateur(formateur());
		return formateurDTO;
	}
	
	@Bean
	@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
	Formateur formateur() {
		logger.info("Execute method formateur2()");
		Formateur formateur = new Formateur();
		formateur.setPrenom("ALI");
		formateur.setNom("BEN MOHAMED");
		return formateur;

	}


}

