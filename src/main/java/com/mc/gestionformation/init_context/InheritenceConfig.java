package com.mc.gestionformation.init_context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.mc.gestionformation.inheritence.ChildBean;
import com.mc.gestionformation.inheritence.ParentBean;

@Configuration
@ComponentScan(basePackageClasses = ParentBean.class)
public class InheritenceConfig {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(InheritenceConfig.class);
		ctx.refresh();
		
		System.out.println(ctx.getBean(ChildBean.class)); 
		System.out.println(ctx.getBean("parentBean",ParentBean.class)); 
	}

}
