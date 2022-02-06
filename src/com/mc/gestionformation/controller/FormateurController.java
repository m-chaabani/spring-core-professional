package com.mc.gestionformation.controller;

import com.mc.gestionformation.dto.FormateurDTO;
import com.mc.gestionformation.service.IFormateurService;

public class FormateurController {

	private FormateurDTO formateurdto;
	private IFormateurService formateurService;

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

	public void setFormateurdto(FormateurDTO formateurdto) {
		this.formateurdto = formateurdto;
	}

}
