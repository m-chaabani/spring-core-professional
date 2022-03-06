package com.mc.gestionformation.view;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mc.gestionformation.controller.FormateurController;
import com.mc.gestionformation.dto.AbstractDTO;

public class InitContext {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		FormateurController formateurController =  ctx.getBean(FormateurController.class);
		formateurController.BoutonEnregister();
		

	}

}
