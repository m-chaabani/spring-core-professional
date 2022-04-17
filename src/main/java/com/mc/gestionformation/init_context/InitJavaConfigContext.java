package com.mc.gestionformation.init_context;





import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.mc.gestionformation.config.AppConfig;
import com.mc.gestionformation.config.DataSourceCfg;
import com.mc.gestionformation.dto.FormateurDTO;

public class InitJavaConfigContext {


	private static final Logger logger = LoggerFactory.getLogger(InitJavaConfigContext.class);

	public static void main(String[] args) {

		logger.info("Running ApplicationContext from {}", InitJavaConfigContext.class.getSimpleName());

		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		Arrays.asList(ctx.getBeanDefinitionNames()).forEach(System.out::println);

//		FormateurController formateurController = ctx.getBean("myFormateurController",FormateurController.class);
//		logger.info(ctx.getBean(Formateur.class).toString());
//		formateurController.BoutonEnregister();

	}

}
