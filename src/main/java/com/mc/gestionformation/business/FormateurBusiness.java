package com.mc.gestionformation.business;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.mc.gestionformation.controller.FormateurController;
import com.mc.gestionformation.dto.FormateurDTO;
import com.mc.gestionformation.integration.dao.IFormateurDao;
import com.mc.gestionformation.model.Formateur;
import com.mc.gestionformation.service.IFormateurService;

@Service("formateurBusiness2")
@Primary
public class FormateurBusiness implements IFormateurService {
	private static Logger logger = LoggerFactory.getLogger(FormateurController.class);
	// IFormateurDao formateurDao = new FormateurDaoInMemory() ;
	IFormateurDao formateurDao = null;

	public FormateurBusiness() {
		logger.info("[bean creation from FormateurBusiness with no-arg constructor]");
	}

  @Autowired
	public FormateurBusiness(IFormateurDao formateurDao) {
		super();
		this.formateurDao = formateurDao;
		logger.info("[bean creation from FormateurBusiness with 1-arg constructor]");
	}

	@Override
	public FormateurDTO enregistrer(FormateurDTO formateurDto) {
		System.out.println("  IN BUSINESS ...");
		System.out.println(" Enregisterment de l'objet Formateur");
		Formateur formateur = formateurDto.getFormateur();
		formateur.setCreatedAt(LocalDate.now());
		formateur.setModifiedAt(LocalDate.now());
		formateurDto = (FormateurDTO) formateurDao.create(formateurDto);
		return formateurDto;
	}

}
