package com.mc.gestionformation.view;

import java.awt.List;
import java.io.ObjectInputFilter.Config;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.mc.gestionformation.config.DataSourceCfg;
import com.mc.gestionformation.config.InitConfig;
import com.mc.gestionformation.dto.FormateurDTO;

class InitJavaConfigContext {

	private static final Logger logger = LoggerFactory.getLogger(InitJavaConfigContext.class);

	public static void main(String[] args) {

		logger.info("Running ApplicationContext from {}", InitJavaConfigContext.class.getSimpleName());

		ApplicationContext ctx = new AnnotationConfigApplicationContext(InitConfig.class);

		Arrays.asList(ctx.getBeanDefinitionNames()).forEach(System.out::println);

		FormateurDTO formateurDto1 = ctx.getBean("formateurDto1", FormateurDTO.class);
		FormateurDTO formateurDto2 = ctx.getBean("formateurDto20", FormateurDTO.class);

		System.out.println("formateurDto1" + formateurDto1.getFormateur());
		System.out.println("formateurDto20" + formateurDto2.getFormateur());
		System.out.println("formateurDto20" + formateurDto2.getFormateur());

		ctx.getBean("initConfig", InitConfig.class).getRatings().forEach(System.out::println);
		System.out.println( ctx.getBean(DataSourceCfg.class) );
		System.out.println( ctx.getBean("dataSourceByEnv",DriverManagerDataSource.class).getUsername() ); 

//		FormateurController formateurController = ctx.getBean("myFormateurController",FormateurController.class);
//		logger.info(ctx.getBean(Formateur.class).toString());
//		formateurController.BoutonEnregister();

	}

}
