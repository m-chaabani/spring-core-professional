package com.mc.gestionformation.view;

import com.mc.gestionformation.business.FormateurBusiness;
import com.mc.gestionformation.controller.FormateurController;
import com.mc.gestionformation.dto.FormateurDTO;
import com.mc.gestionformation.dto.FormateurDTOMapper;
import com.mc.gestionformation.dto.FormateurDTOMapperImpl;
import com.mc.gestionformation.model.Formateur;
import com.mc.gestionformation.service.FormateurService;
import com.mc.gestionformation.service.IFormateurService;

public class FormateurView {
	
	public static void main(String[] args) {
		
		System.out.println("  START...");
		System.out.println("  IN VIEW START...");
		IFormateurService formateurRealBusiness = new FormateurBusiness();
		IFormateurService formateurBusinessPROXY = new FormateurService(formateurRealBusiness);

		FormateurController controller = new FormateurController(formateurBusinessPROXY);
		Formateur formateur = new Formateur();
		formateur.setNom("Noureddine");
		formateur.setPrenom("BOUBEKEUR");
		
		FormateurDTOMapper formateurMapper = new FormateurDTOMapperImpl();
		
		FormateurDTO formateurDto = formateurMapper.formateurToDTO(formateur);
	
		
		controller.setFormateurdto(formateurDto);
		controller.BoutonEnregister();
		System.out.println("  IN VIEW END...");
	}

}
