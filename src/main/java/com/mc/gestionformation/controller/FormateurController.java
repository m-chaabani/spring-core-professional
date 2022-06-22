package com.mc.gestionformation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mc.gestionformation.aspect.Loggable;
import com.mc.gestionformation.dto.FormateurDTO;
import com.mc.gestionformation.service.IFormateurService;

@Component
@Loggable
public class FormateurController {
	
	
	private static Logger logger = LoggerFactory.getLogger(FormateurController.class);

	private FormateurDTO formateurdto;
	private IFormateurService formateurService;

	@Autowired
	public FormateurController(@Qualifier("formateurService") IFormateurService formateurService) {
		super();
		this.formateurService = formateurService;
		logger.info("[bean creation from FormateurController with 1-arg constructor]");
	}

	public void BoutonEnregister() {
		System.out.println("  IN CONTROLLER ...");
		System.out.println(" Validation des données au niveau controller effectué ");

		formateurdto = formateurService.enregistrer(formateurdto);
		System.out.println(" Formateur enregistré avec success : " + formateurdto.getEntity());
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
