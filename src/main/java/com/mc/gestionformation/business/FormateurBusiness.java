package com.mc.gestionformation.business;

import java.time.LocalDate;

import com.mc.gestionformation.dto.FormateurDTO;
import com.mc.gestionformation.integration.dao.FormateurDaoInMemory;
import com.mc.gestionformation.model.Formateur;
import com.mc.gestionformation.service.IFormateurService;

public class FormateurBusiness implements IFormateurService {
	
	FormateurDaoInMemory formateurDao = new FormateurDaoInMemory() ;

	@Override
	public FormateurDTO enregistrer(FormateurDTO formateurDto) {
		System.out.println("  IN BUSINESS ...");
		System.out.println(" Enregisterment de l'objet Fomratuer");
		Formateur formateur = formateurDto.getFormateur() ;
		formateur.setCreatedAt(LocalDate.now());
		formateur.setModifiedAt(LocalDate.now());
		formateurDto = formateurDao.enregistrer(formateurDto);
		return formateurDto;
	}
	
	
	
}
