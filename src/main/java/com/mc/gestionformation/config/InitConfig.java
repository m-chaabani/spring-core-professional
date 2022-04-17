package com.mc.gestionformation.config;

import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

import com.mc.gestionformation.dto.FormateurDTO;
import com.mc.gestionformation.model.Formateur;
import com.mc.gestionformation.model.Rating;
import com.mc.gestionformation.view.MyBean;
import com.mc.gestionformation.view.MyBeanCreator;

//Java Config à partir de Spring 3.0
//FactoryBeanPostProcessor
@Configuration
@ComponentScan(basePackages = "com.mc")
@Import(DataSourceCfg.class)
//@ImportResource(locations = "classpath:spring/applicationContext.xml")
public class InitConfig {

	Logger logger = LoggerFactory.getLogger(InitConfig.class);

	@Autowired
	DataSourceCfg dataSourceCfg;
	
	@Autowired
	List<Rating> ratings;

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



	// Factory Method instantiation
	@Bean
	MyBean myBean() {
		return MyBean.getInstance();
	}

	// factory Bean Instanciation
	@Bean
	MyBean myBean2() {
		return new MyBeanCreator().createMyBean();
	}
	
	
	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

}
