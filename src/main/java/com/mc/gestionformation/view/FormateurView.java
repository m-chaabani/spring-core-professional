package com.mc.gestionformation.view;

import com.mc.gestionformation.controller.FormateurController;
import com.mc.gestionformation.dto.FormateurDTO;
import com.mc.gestionformation.dto.FormateurDTOMapper;
import com.mc.gestionformation.dto.FormateurDTOMapperImpl;
import com.mc.gestionformation.model.Formateur;

public class FormateurView {
	
	public static void main(String[] args) {
		
	    // construction de l'object DTO : porteur de données
		Formateur formateur = new Formateur();
		formateur.setNom("Noureddine");
		formateur.setPrenom("BOUBEKEUR");
		FormateurDTOMapper formateurMapper = new FormateurDTOMapperImpl();
		FormateurDTO formateurDto = formateurMapper.formateurToDTO(formateur);
	    
		
		FormateurFactory factory = MyFormateurFactory.getInstance();
		FormateurController controller = (FormateurController) factory.getFormateurComponent("mycontroller");
		controller.setFormateurdto(formateurDto);
		controller.BoutonEnregister();
	
	}

}
