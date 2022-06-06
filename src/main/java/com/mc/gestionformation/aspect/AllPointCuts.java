package com.mc.gestionformation.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class AllPointCuts {

	@Pointcut("@within(com.mc.gestionformation.aspect.Loggable)")
	// Equivalent : @Pointcut("within(@com.mc.gestionformation.aspect.Loggable *)")
	public void loggableForType() {

	}
	
	@Pointcut("@annotation(com.mc.gestionformation.aspect.Loggable)")
	// Equivalent : @Pointcut("within(@com.mc.gestionformation.aspect.Loggable *)")
	public void loggableForMethod() {

	}
	
	@Pointcut("this(com.mc.gestionformation.service.IFormateurService)")
	public void logIformateurService() {

	}

}