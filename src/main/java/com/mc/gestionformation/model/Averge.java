package com.mc.gestionformation.model;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class Averge implements Rating{

	@Override
	public int getRating() {
		return 3;
	}
	

}
