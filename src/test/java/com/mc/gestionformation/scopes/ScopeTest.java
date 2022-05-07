package com.mc.gestionformation.scopes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mc.gestionformation.config.AppConfig;
import com.mc.gestionformation.model.Formateur;

public class ScopeTest {
	Logger logger = LoggerFactory.getLogger(ScopeTest.class);

	@Test
	public void testSingleton() {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfig.class);
		ctx.refresh();
		
		Formateur f1 = ctx.getBean("formateurSingleton", Formateur.class);
		Formateur f2 = ctx.getBean("formateurSingleton", Formateur.class);
		
		
		logger.info("f1.hashCode()" + f1.hashCode());
		logger.info("f2.hashCode()" + f2.hashCode());
		
		
		assertEquals(f1, f2);
		
		
	}
	
	@Test
	public void testPrototype() {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfig.class);
		ctx.refresh();
		
		Formateur f1 = ctx.getBean("formateurPrototypeWithoutProxy", Formateur.class);
		Formateur f2 = ctx.getBean("formateurPrototypeWithoutProxy", Formateur.class);
		
		
		logger.info("f1.hashCode()" + f1.hashCode());
		logger.info("f2.hashCode()" + f2.hashCode());
		
		
		assertNotEquals(f1, f2);
		
	
	}
	
	

}
