package com.mc.gestionformation.integration.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.mc.gestionformation.dto.FormateurDTO;
import com.mc.gestionformation.dto.FormateurDTOMapper;
import com.mc.gestionformation.dto.FormateurDTOMapperImpl;
import com.mc.gestionformation.model.Formateur;


@Repository
@Primary
public class FormateurDaoInMemory implements IFormateurDao{

	private static List<Formateur> FORMATEURS = new ArrayList<Formateur>();
	private FormateurDTOMapper formateurMapper = new FormateurDTOMapperImpl();

	public FormateurDTO enregistrer(FormateurDTO formateurdto) {
///		int i = 0/0;
		int nextIndice = FORMATEURS.size()+1; 
		Formateur formateur = formateurMapper.DTOToformateur(formateurdto);
		formateur.setId( (long)(nextIndice));
		FORMATEURS.add(formateur);
		return formateurdto;	
	
	}

	@Override
	public FormateurDTO create(FormateurDTO formateurDTO) {
		
		int nextIndice = FORMATEURS.size()+1; 
		Formateur formateur = formateurMapper.DTOToformateur(formateurDTO);
		formateur.setId( (long)(nextIndice));
		FORMATEURS.add(formateur);
		return formateurDTO;
		
	}

	@Override
	public FormateurDTO update(FormateurDTO formateurDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FormateurDTO delete(FormateurDTO formateurDTO) {
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
