package com.mc.gestionformation.integration.dao;

import com.mc.gestionformation.dto.FormateurDTO;

public interface IFormateurDao {
	
	FormateurDTO create(FormateurDTO formateurDTO);

	FormateurDTO update(FormateurDTO formateurDTO);

	FormateurDTO delelte(FormateurDTO formateurDTO);

	FormateurDTO findById(FormateurDTO formateurDTO);

	FormateurDTO findAll();

}
