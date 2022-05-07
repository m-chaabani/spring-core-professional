package com.mc.gestionformation.scopes.proxymode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="singleton")
public class MySingletonThatDependsOnPrototype {
	
	

	@Autowired
	MyInterfaceToBeProxied myinterfaceProxiedDependency ;
	
	@Autowired
	MyPrototypeTargetClassProxied myPrototypeTargetClassProxied;
	
	@Autowired
	WebScopeDependency webScopeDependency;
	
	private void m1() {
		myinterfaceProxiedDependency.methodToProxy1();

	}
	
	
}
