package com.mc.gestionformation.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.mc.gestionformation.dto.FormateurDTO;
import com.mc.gestionformation.model.Formateur;


@Configuration
@ComponentScan(basePackages = "com.mc")
@Import(DataSourceCfg.class)
@EnableAspectJAutoProxy(proxyTargetClass = true) // activation de la prise en charge des aspects par ASPECTJ
public class AppConfig {

	Logger logger = LoggerFactory.getLogger(AppConfig.class);

	@Autowired
	DataSourceCfg dataSourceCfg;

	@Bean(name = "formateurDto1")
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
