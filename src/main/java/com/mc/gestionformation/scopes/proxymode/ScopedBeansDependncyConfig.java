package com.mc.gestionformation.scopes.proxymode;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = ScopedBeansDependncyConfig.class)
public class ScopedBeansDependncyConfig {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
				ScopedBeansDependncyConfig.class);
			
		
		MySingletonThatDependsOnPrototype mySingleton = ctx.getBean(MySingletonThatDependsOnPrototype.class);
		MySingletonThatDependsOnPrototype mySingleton2 = ctx.getBean(MySingletonThatDependsOnPrototype.class);
		Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);
	}
}
