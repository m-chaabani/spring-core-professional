package com.mc.gestionformation.integration.dao;

import com.mc.gestionformation.dto.FormateurDTO;
import com.mc.gestionformation.model.Formateur;

public interface IFormateurDAO extends IDAO<Formateur> {
	
	FormateurDTO findByDiscipline(FormateurDTO dto);
	
}
