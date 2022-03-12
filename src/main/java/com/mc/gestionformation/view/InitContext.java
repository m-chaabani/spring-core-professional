package com.mc.gestionformation.view;

import java.util.Locale;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.mc.gestionformation.controller.FormateurController;
import com.mc.gestionformation.model.Formateur;

public class InitContext {

	public static void main(String[] args) {
		// useXMLBeanFactory();
		useApplicatioContextWithClassPath();
		// useApplicatioContextWithFileSystem();
		// getBean byType with many instance of that type

	}

	public static void useXMLBeanFactory() {
		Resource resource = new ClassPathResource("classpath:spring/applicationContext.xml");
		BeanFactory ctx = new XmlBeanFactory(resource);
		FormateurController formateurController = ctx.getBean(FormateurController.class);
		formateurController.BoutonEnregister();
	}

	public static void useApplicatioContextWithClassPath() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		ConfigurableApplicationContext cctx = (ConfigurableApplicationContext) ctx;

		System.out.println(cctx.getBean("formateur2", Formateur.class).toString());
		
		if(true)
			return;
		
		
		
//       Si le bean n'exite pas 		
//		Caused by: org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'formateur' available

		
		
		System.out.println(cctx.getBean(Formateur.class).toString());
//      Get By Type if many beans result in this exception
//		Exception in thread "main" org.springframework.beans.factory.NoUniqueBeanDefinitionException

	}

	public static void useApplicatioContextWithClassPathCapability() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ConfigurableApplicationContext cctx = (ConfigurableApplicationContext) ctx;

		/*
		 * 
		 * // EventPublisher capability
		 * 
		 */
		// EventPublisher
		// 1. Publisher
		// 2. Listner
		// 3. Event
		cctx.registerShutdownHook();
		cctx.refresh();
		cctx.refresh();
		cctx.refresh();

//		cctx.refresh(); // --> ContextRefreshedEvent.class
//		cctx.start(); // ContextStartedEvent.class
//		cctx.stop(); // ContextStoppedEvent.class
//		cctx.close() ; // ContextStoppedEvent.class

		/*
		 * 
		 * // Resource capability
		 * 
		 */
		// classpath: --> CLASS-PATH
		// file: --> FileSystem ou Network \\...
		// http://www.....
		Resource rsc = ctx.getResource("file:spring/applicationContext.xml");

		/*
		 * 
		 * // internationalization Capabilty of ApplicationContext
		 * 
		 */
		String usernameLogin = ctx.getMessage("username.login", null, Locale.getDefault());
		System.out.println("usernameLogin .... DEFAULT  : " + usernameLogin);
		usernameLogin = ctx.getMessage("username.login", null, new Locale("en"));
		System.out.println("usernameLogin .... EN  : " + usernameLogin);

		FormateurController formateurController = ctx.getBean(FormateurController.class);
		formateurController.BoutonEnregister();

		cctx.stop();
	}

	public static void useApplicatioContextWithFileSystem() {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("\\dev\\config_files\\beans.xml");
		ConfigurableApplicationContext cctx = (ConfigurableApplicationContext) ctx;
		ctx.getBean(FormateurController.class).BoutonEnregister();
	}

}
