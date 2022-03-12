package com.mc.gestionformation.view;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.mc.gestionformation.controller.FormateurController;



@Component
public class InitContext {
	
	private static final Logger logger = LoggerFactory.getLogger(InitContext.class);


    

	public static void main(String[] args) {
		logger.info("Running ApplicationContext from {}", InitContext.class.getSimpleName());

		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		FormateurController formateurController = ctx.getBean(FormateurController.class);

		formateurController.BoutonEnregister();
		

	}

	
	public static void useClassPathXmlApplicationContext() {
		//creating the context
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		// Get the bean to use to invoke the service
		FormateurController formateurController = ctx.getBean(FormateurController.class);
		// invoking the save method of the bean
		formateurController.BoutonEnregister();

		// show all loaded beans
		Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);
	}

	public static void useBeanFactory() {
		BeanFactory ctx = new XmlBeanFactory(new ClassPathResource("spring/applicationContext.xml"));
		FormateurController formateurController = ctx.getBean(FormateurController.class);
		formateurController.BoutonEnregister();

		// show all loaded beans
		ListableBeanFactory lbf = ListableBeanFactory.class.cast(ctx);
		Arrays.stream(lbf.getBeanDefinitionNames()).forEach(System.out::println);
	}

}
