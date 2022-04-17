package com.mc.gestionformation.view;

import java.util.Arrays;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.mc.gestionformation.controller.FormateurController;
import com.mc.gestionformation.model.Formateur;

public class InitXMLContext {

	private static final Logger logger = LoggerFactory.getLogger(InitXMLContext.class);

	public static void main(String[] args) {
		// useXMLBeanFactory();
		// useApplicatioContextWithClassPath();
		// useApplicatioContextWithFileSystem();
		// getBean byType with many instance of that type

		logger.info("Running ApplicationContext from {}", InitXMLContext.class.getSimpleName());

//		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/applicationContext.xml",
//				"spring/applicationContext-infra.xml", "spring/applicationContext-security.xml");
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		DriverManagerDataSource ds = ctx.getBean(DriverManagerDataSource.class);
		System.out.println("ds.getPassword()" + ds.getPassword() );
		System.out.println("ds.getUsername()" + ds.getUsername() );
		System.out.println("ds.getUrl()" + ds.getUrl() );

		
	//	System.out.println(ctx.getBean("initConfig"));
//        Arrays.asList(ctx.getBeanDefinitionNames() ).forEach(System.out::println);
//		
//		FormateurController formateurController = ctx.getBean(FormateurController.class);
//		logger.info(ctx.getBean(Formateur.class).toString());
//		formateurController.BoutonEnregister();

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

		if (true)
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

	public static void useClassPathXmlApplicationContext() {
		// creating the context
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		// Get the bean to use to invoke the service
		FormateurController formateurController = ctx.getBean(FormateurController.class);
		// invoking the save method of the bean
		formateurController.BoutonEnregister();
		// show all loaded beans
		Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);

	}

}
