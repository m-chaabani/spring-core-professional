package com.mc.gestionformation.dto;

import com.mc.gestionformation.model.Formateur;

public interface FormateurDTOMapper {
	
	FormateurDTO formateurToDTO(Formateur formateur);
	Formateur DTOToformateur(FormateurDTO formateur);

}
