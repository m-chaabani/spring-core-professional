package com.mc.gestionformation.integration.dao;

import java.util.ArrayList;
import java.util.List;

import com.mc.gestionformation.dto.FormateurDTO;
import com.mc.gestionformation.dto.FormateurDTOMapper;
import com.mc.gestionformation.dto.FormateurDTOMapperImpl;
import com.mc.gestionformation.model.Formateur;

public class FormateurDaoInMemory {

	private static List<Formateur> FORMATEURS = new ArrayList<Formateur>();
	private FormateurDTOMapper formateurMapper = new FormateurDTOMapperImpl();

	public FormateurDTO enregistrer(FormateurDTO formateurdto) {
///		int i = 0/0;
		
		
		int nextIndice = FORMATEURS.size()+1; 
		Formateur formateur = formateurMapper.DTOToformateur(formateurdto);
		formateur.setId( (long)(nextIndice));
		FORMATEURS.add(formateur);
		return formateurdto;
	}

}
