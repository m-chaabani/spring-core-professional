package com.mc.gestionformation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mc.gestionformation.model.Formation;

@Controller
@RequestMapping("/formations")
public class FormationController {

	private Formation formation;

	@ModelAttribute
	public void init() {
		formation = new Formation();

	}

	@PostMapping("/create")
	String create(@ModelAttribute @Validated Formation formation, BindingResult result) {
		return "showPerson";
	}

}
