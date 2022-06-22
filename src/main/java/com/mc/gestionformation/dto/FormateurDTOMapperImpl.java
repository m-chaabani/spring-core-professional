package com.mc.gestionformation.dto;

import com.mc.gestionformation.model.Formateur;

public class FormateurDTOMapperImpl implements FormateurDTOMapper {

	@Override
	public FormateurDTO formateurToDTO(Formateur formateur) {
		FormateurDTO formateurDto = new FormateurDTO();
		formateurDto.setEntity(formateur);
		return formateurDto;
	}

	@Override
	public Formateur DTOToformateur(FormateurDTO formateurDto) {
		Formateur formateur = formateurDto.getEntity();
		return formateur;
	}

}
