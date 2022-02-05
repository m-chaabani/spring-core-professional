package com.mc.gestionformation.controller;

import java.time.LocalDate;

import com.mc.gestionformation.model.Formateur;
import com.mc.gestionformation.service.FormateurService;

public class FormateurController {

	private Formateur formateur;
	private FormateurService formateurService = new FormateurService();

	public void BoutonEnregister() {
		System.out.println(" Validation des données au niveau controller effectué ");
		
		formateur = formateurService.enregistrer(formateur);
		System.out.println(" Formateur enregistré avec success : " + formateur);
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}


}
