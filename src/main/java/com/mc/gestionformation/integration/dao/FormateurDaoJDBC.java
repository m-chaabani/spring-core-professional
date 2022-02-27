package com.mc.gestionformation.integration.dao;

import com.mc.gestionformation.dto.FormateurDTO;

public class FormateurDaoJDBC implements IFormateurDao {
	
	public Object save(Object o) {
		return 1;
	}

	@Override
	public FormateurDTO create(FormateurDTO formateurDTO) {
		return formateurDTO;
	}

	@Override
	public FormateurDTO update(FormateurDTO formateurDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FormateurDTO delelte(FormateurDTO formateurDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FormateurDTO findById(FormateurDTO formateurDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FormateurDTO findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
