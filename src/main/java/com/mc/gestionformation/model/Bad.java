package com.mc.gestionformation.model;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(4)
public class Bad implements Rating {

	@Override
	public int getRating() {
		return 4;
	}

}
