package com.mc.gestionformation.business;

import java.time.LocalDate;

import com.mc.gestionformation.integration.dao.FormateurDaoInMemory;
import com.mc.gestionformation.model.Formateur;

public class FormateurBusiness {
	
	FormateurDaoInMemory formateurDao = new FormateurDaoInMemory() ;

	public Formateur enregistrer(Formateur formateur) {
		
		formateur.setCreatedAt(LocalDate.now());
		formateur.setModifiedAt(LocalDate.now());
		formateur = formateurDao.enregistrer(formateur);
		return formateur;
	}
	
	
	
}
