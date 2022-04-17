package com.mc.gestionformation.integration.dao;

import java.sql.SQLException;

import com.mc.gestionformation.dto.FormateurDTO;

public interface IFormateurDao {
	
	FormateurDTO create(FormateurDTO formateurDTO);

	FormateurDTO update(FormateurDTO formateurDTO);

	FormateurDTO delete(FormateurDTO formateurDTO);

	FormateurDTO findById(FormateurDTO formateurDTO);

	FormateurDTO findAll() throws SQLException;

}
