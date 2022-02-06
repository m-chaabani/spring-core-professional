package com.mc.gestionformation.integration.dao;

import java.util.ArrayList;
import java.util.List;

import com.mc.gestionformation.dto.FormateurDTO;
import com.mc.gestionformation.model.Formateur;

public class FormateurDaoInMemory {

	private static List<Formateur> FORMATEURS = new ArrayList<Formateur>();

	public FormateurDTO enregistrer(FormateurDTO formateurdto) {
///		int i = 0/0;
		
		
		int nextIndice = FORMATEURS.size()+1; 
		Formateur formateur = formateurdto.getFormateur();
		formateur.setId( (long)(nextIndice));
		FORMATEURS.add(formateur);
		return formateurdto;
	}

}
