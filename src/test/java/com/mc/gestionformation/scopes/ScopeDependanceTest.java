package com.mc.gestionformation.scopes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mc.gestionformation.config.AppConfig;
import com.mc.gestionformation.dto.FormateurDTO;

public class ScopeDependanceTest {
	
	Logger logger = LoggerFactory.getLogger(ScopeDependanceTest.class);
	
	
//	@Test
//	public void testSingletonDependsOnSingleton() {
//		
//		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//		ctx.register(AppConfig.class);
//		ctx.refresh();
//		
//		FormateurDTO f1 = ctx.getBean("formateurDto2", FormateurDTO.class);
//		FormateurDTO f2 = ctx.getBean("formateurDto2", FormateurDTO.class);
//		
//		
//		logger.info("dto1.hashCode()" + f1.hashCode());
//		logger.info("dto2.hashCode()" + f2.hashCode());
//		
//		logger.info("f1.getFormateur().hashCode()" + f1.getFormateur().hashCode());
//		logger.info("f2.getFormateur().hashCode()" + f2.getFormateur().hashCode());
//		
//		logger.info("f1.getFormateur().getSalaire()" + f1.getFormateur().getSalaire());
//		logger.info("f2.getFormateur().getSalaire()" + f2.getFormateur().getSalaire());
//		
//		
//		assertEquals(f1, f2);
//		assertEquals(f1.getFormateur(), f2.getFormateur());
//		
//	
//	}
//	
	
//	@Test
//	public void testPrototypeDependsOnSingleton() {
//		
//		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//		ctx.register(AppConfig.class);
//		ctx.refresh();
//		
//		FormateurDTO f1 = ctx.getBean("formateurDtoPrototype", FormateurDTO.class);
//		FormateurDTO f2 = ctx.getBean("formateurDtoPrototype", FormateurDTO.class);
//		
//		
//		logger.info("dto1.hashCode()" + f1.hashCode());
//		logger.info("dto2.hashCode()" + f2.hashCode());
//		
//		logger.info("f1.hashCode()" + f1.getFormateur().hashCode());
//		logger.info("f2.hashCode()" + f2.getFormateur().hashCode());
//		
//		
//		assertNotEquals(f1, f2);
//		assertEquals(f1.getFormateur(), f2.getFormateur());
//		
//	
//	}
//	
	
	@Test
	public void testSingletonDependsOnPrototype() {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfig.class);
		ctx.refresh();
		
		FormateurDTO f1 = ctx.getBean("formateurDtoSingletonOnPrototype", FormateurDTO.class);
		FormateurDTO f2 = ctx.getBean("formateurDtoSingletonOnPrototype", FormateurDTO.class);
		
		logger.info("dto1.hashCode()" + f1.hashCode());
		logger.info("dto2.hashCode()" + f2.hashCode());
		
		logger.info("f1.getFormateur().hashCode()" + f1.getFormateur().hashCode());
		logger.info("f2.getFormateur().hashCode()" + f2.getFormateur().hashCode());
		
		logger.info("f1.getFormateur().getSalaire()" + f1.getFormateur().getSalaire());
		logger.info("f2.getFormateur().getSalaire()" + f2.getFormateur().getSalaire());
		
		
		assertEquals(f1, f2);
		assertEquals(f1.getFormateur(), f2.getFormateur());
		
	
	}
	
}
