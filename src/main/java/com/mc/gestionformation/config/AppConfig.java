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


@Configuration
@ComponentScan(basePackages = "com.mc")
@Import(DataSourceCfg.class)
public class AppConfig {

	Logger logger = LoggerFactory.getLogger(AppConfig.class);

	@Autowired
	DataSourceCfg dataSourceCfg;

	@Bean(name = "formateurDto20")
	FormateurDTO formateurDto2() {
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

}
