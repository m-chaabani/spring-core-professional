package com.mc.gestionformation.inheritence;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ParentBean {

	@Value("Ben Salah")
	protected String familyName;
	protected String surname;

	public ParentBean( @Value("Mohamed") String surname) {
		super();
		this.surname = surname;
	}

	@Override
	public String toString() {
		return "ParentBean [familyName=" + familyName + ", surname=" + surname + "]";
	}
	
	

}
