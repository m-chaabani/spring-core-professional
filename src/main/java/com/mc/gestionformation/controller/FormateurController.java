package com.mc.gestionformation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.mc.gestionformation.dto.FormateurDTO;
import com.mc.gestionformation.service.IFormateurService;

@Component("myFormateurController")
@Primary
// load definition bean Component( scope : singleton, class =  FormateurController.class
//                                      id ="formateurController" , Primary = "true"
//                                      lazy-init= false )
// bean creation : new FormateurController(ctx.getBean("formateurService") )
@Profile("dev")
public class FormateurController {

	private static Logger logger = LoggerFactory.getLogger(FormateurController.class);

	private FormateurDTO formateurdto;
	private IFormateurService formateurService;

	public FormateurController() {
		super();

	}

	public FormateurController(IFormateurService formateurService) {
		super();
		this.formateurService = formateurService;
	}

	public void BoutonEnregister() {
		System.out.println("  IN CONTROLLER ...");
		System.out.println(" Validation des données au niveau controller effectué ");

		formateurdto = formateurService.enregistrer(formateurdto);
		System.out.println(" Formateur enregistré avec success : " + formateurdto.getFormateur());
	}

	public FormateurDTO getFormateurdto() {
		return formateurdto;
	}

	@Autowired
	
	public void setFormateurdto(@Qualifier("formateurDto1")FormateurDTO formateurdto) {
		System.out.println("[ formateurdto in Controller ] : " + formateurdto);
		this.formateurdto = formateurdto;
	}

}
