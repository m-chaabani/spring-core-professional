package com.mc.gestionformation.business;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mc.gestionformation.config.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class TestFormateurBusiness {

	@Autowired
	FormateurBusiness formateurBusiness;

	@Test
	public void testAllFormateursNotNull() {
		formateurBusiness.allFormateurs.forEach(System.out::println);

	}
	
	
	
//	ApplicationContext context;

//	@Before
//	public void initContext() {
//		context = new AnnotationConfigApplicationContext(AppConfig.class);
//
//	}

//	@Test
//	public void testAllFormateursNotNull() {
//		context.getBean(FormateurBusiness.class).allFormateurs.forEach(System.out::println);
//	}

}
