package com.mc.gestionformation.scopes.proxymode;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component("myPrototypeInterfacesProxied")
@Scope(scopeName = "prototype",proxyMode = ScopedProxyMode.INTERFACES)
public class MyPrototypeInterfacesProxied implements MyInterfaceToBeProxied{

	@Override
	public void methodToProxy1() {
		System.out.println("methodToProxy1");
	}

	@Override
	public void methodToProxy2() {
		System.out.println("methodToProxy2");
	}

}
