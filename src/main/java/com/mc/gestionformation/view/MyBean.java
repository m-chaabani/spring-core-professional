package com.mc.gestionformation.view;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public abstract class MyBean {

	private MyBean() {

	}


    //factory method
	
	public static MyBean getInstance() {
		return new MyBean() {
		};
	}
	

}
