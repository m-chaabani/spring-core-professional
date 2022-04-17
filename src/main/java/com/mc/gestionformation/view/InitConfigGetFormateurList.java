package com.mc.gestionformation.view;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mc.gestionformation.config.InitConfig;
import com.mc.gestionformation.integration.dao.FormateurDaoJDBC;

public class InitConfigGetFormateurList {
	private static final Logger logger = LoggerFactory.getLogger(InitJavaConfigContext.class);

	public static void main(String[] args) throws SQLException {

		logger.info("Running ApplicationContext from {}", InitJavaConfigContext.class.getSimpleName());

		ApplicationContext ctx = new AnnotationConfigApplicationContext(InitConfig.class);
		FormateurDaoJDBC formateurDao = ctx.getBean(FormateurDaoJDBC.class);
		formateurDao.findAll().getFormateurs().forEach(System.out::println);

	}

}
