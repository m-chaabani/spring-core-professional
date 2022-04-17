package com.mc.gestionformation.model;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.CLASS;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@Retention(CLASS)
@Target({ METHOD, ANNOTATION_TYPE })
@Bean
@Scope("prototype")
public @interface BeanPrototype {

}
