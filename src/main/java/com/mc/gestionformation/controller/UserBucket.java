package com.mc.gestionformation.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.mc.gestionformation.model.Formation;

@Component
@SessionScope
public class UserBucket {
	private Iterable<Formation> formations = new ArrayList<Formation>();

}
