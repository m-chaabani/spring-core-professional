package com.mc.gestionformation.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.annotation.ApplicationScope;

import com.mc.gestionformation.dto.FormateurDTO;
import com.mc.gestionformation.model.Formateur;



public class AppScopeConfig {
	
	Logger logger = LoggerFactory.getLogger(AppConfig.class);

	@Bean
	FormateurDTO formateurDto1() {
		FormateurDTO formateurDTO = new FormateurDTO();
		formateurDTO.setFormateur(formateurSingleton());
		return formateurDTO;
	}


	@Bean(name = "formateurDto2")
	FormateurDTO formateurDto2() {
		FormateurDTO formateurDTO = new FormateurDTO();
		formateurDTO.setFormateur(formateur2());
		return formateurDTO;
	}
	
	
	


	@Bean
	@Scope(value="prototype", proxyMode = ScopedProxyMode.INTERFACES )
	Formateur formateurPrototype() {
		logger.info("Execute method formateurPrototype()");
		Formateur formateur = new Formateur();
		formateur.setPrenom("SALAH");
		formateur.setNom("BEN MOHAMED");
		return formateur;

	}
	
	
	@Bean
	@ApplicationScope
	Formateur formateurPrototypeWithoutProxy() {
		logger.info("Execute method formateurPrototypeWithoutProxy()");
		Formateur formateur = new Formateur();
		formateur.setPrenom("SALAH");
		formateur.setNom("BEN MOHAMED");
		return formateur;

	}

	@Bean
	@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
	Formateur formateur2() {
		logger.info("Execute method formateur2()");
		Formateur formateur = new Formateur();
		formateur.setPrenom("ALI");
		formateur.setNom("BEN MOHAMED");
		return formateur;

	}
	
	
	@Bean(name = "formateurDtoPrototype")
	@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	FormateurDTO formateurDto2Prototype() {
		FormateurDTO formateurDTO = new FormateurDTO();
		formateurDTO.setFormateur(formateurSingleton());
		return formateurDTO;
	}
	
	@Bean(name="formateurSingleton")
	@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
	Formateur formateurSingleton() {
		logger.info("Execute method formateur2()");
		Formateur formateur = new Formateur();
		formateur.setPrenom("ALI");
		formateur.setNom("BEN MOHAMED");
		return formateur;

	}
	
	
	@Bean(name = "formateurDtoSingletonOnPrototype")
	@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
	FormateurDTO formateurDtoSingletonOnProt() {
		FormateurDTO formateurDTO = new FormateurDTO();
		formateurDTO.setFormateur(formateurPrototype());
		return formateurDTO;
	}
	
	
	
	
	
	

}
