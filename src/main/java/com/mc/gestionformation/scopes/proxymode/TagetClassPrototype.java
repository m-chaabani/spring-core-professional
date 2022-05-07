package com.mc.gestionformation.scopes.proxymode;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.CLASS;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.annotation.AliasFor;
import org.springframework.web.context.annotation.RequestScope;

@Retention(CLASS)
@Target({ METHOD, ANNOTATION_TYPE })
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@RequestScope
public @interface TagetClassPrototype {

	@AliasFor(annotation = Scope.class, attribute = "")
	ScopedProxyMode proxyMode() default ScopedProxyMode.DEFAULT;
}
