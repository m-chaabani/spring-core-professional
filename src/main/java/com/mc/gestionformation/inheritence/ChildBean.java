package com.mc.gestionformation.inheritence;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ChildBean extends ParentBean {

	protected Boolean adult;

	public ChildBean(  @Value("Ali") String surname, @Value("false") Boolean adult) {
		super(surname);
		this.adult = adult;
	}

	@Override
	public String toString() {
		return "ChildBean [adult=" + adult + ", familyName=" + familyName + ", surname=" + surname + "]";
	}
	
	

}
