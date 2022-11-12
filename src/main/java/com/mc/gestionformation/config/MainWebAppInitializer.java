package com.mc.gestionformation.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

// la classe qui remplace le Fichier WEB.XML : à partir de la version Servlet 3.0+
public class MainWebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(final ServletContext sc) throws ServletException { 
		
		System.out.println("Sans WEB.XML");
		 AnnotationConfigWebApplicationContext root = new     
		                             AnnotationConfigWebApplicationContext(); 
		root.scan("com.mc"); 
		sc.addListener(new ContextLoaderListener(root)); 
		ServletRegistration.Dynamic appServlet = sc.addServlet("mvc", new DispatcherServlet(new GenericWebApplicationContext())); appServlet.setLoadOnStartup(1); 
		appServlet.addMapping("/"); 
		} 


}
