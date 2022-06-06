package com.mc.gestionformation.integration.dao;

import com.mc.gestionformation.dto.FormateurDTO;

public interface IFormateurDAO extends IDAO<FormateurDTO> {
	
	FormateurDTO findByDiscipline(FormateurDTO dto);
	// int totalNumber();
}
