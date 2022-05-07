package com.mc.gestionformation.init_context;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;

public class BFPPExample {

	private static final Logger logger = LoggerFactory.getLogger(BFPPExample.class);

	public static void main(String[] args) {

		logger.info("Running ApplicationContext from {}", BFPPExample.class.getSimpleName());
		ApplicationContext ctx = new AnnotationConfigApplicationContext(BFPPConfig.class);
		Arrays.asList(ctx.getBeanDefinitionNames()).forEach(System.out::println);

	}

}

@Configuration
class BFPPConfig {

	@Bean
	String myName() {
		return "Noureddine";

	}
	
	@Bean
	String myName2() {
		return "Chiraz";

	}

	@Bean
	static MyFirstBFPP MyFirstBFPP() {
		return new MyFirstBFPP();
	}

}

class MyFirstBFPP implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println(" postProcessBeanFactory is executed ");

	}

}
