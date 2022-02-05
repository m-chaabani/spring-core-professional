package com.mc.gestionformation.integration.dao;

import java.util.ArrayList;
import java.util.List;

import com.mc.gestionformation.model.Formateur;

public class FormateurDaoInMemory {

	private static List<Formateur> FORMATEURS = new ArrayList<Formateur>();

	public Formateur enregistrer(Formateur formateur) {
		int nextIndice = FORMATEURS.size()+1; 
		formateur.setId( (long)(nextIndice));
		FORMATEURS.add(formateur);
		return formateur;
	}

}
