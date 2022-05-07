package com.mc.gestionformation.scopes.proxymode;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component("MyPrototypeTargetClassProxied")
@Scope(value="prototype",proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyPrototypeTargetClassProxied {

}
