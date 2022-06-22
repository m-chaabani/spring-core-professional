package com.mc.gestionformation.business;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mc.gestionformation.dto.FormateurDTO;
import com.mc.gestionformation.integration.dao.IFormateurDAO;
import com.mc.gestionformation.model.Formateur;
import com.mc.gestionformation.service.IFormateurService;

@Service("formateurBusiness")
public class FormateurBusiness implements IFormateurService {
	private static Logger logger = LoggerFactory.getLogger(FormateurBusiness.class);
	IFormateurDAO formateurDao = null;

	@Autowired
	public FormateurBusiness(IFormateurDAO formateurDao) {
		super();
		this.formateurDao = formateurDao;
		logger.info("[bean creation from FormateurBusiness with 1-arg constructor]");
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public FormateurDTO enregistrer(FormateurDTO formateurDto) {
		
		formateurDto = this.findById(formateurDto);
		Formateur formateur = formateurDto.getEntity();
		formateur.setCreatedAt(LocalDate.now());
		formateur.setModifiedAt(LocalDate.now());
		formateur = formateurDao.create(formateur);
		logger.info(" in business " + formateurDto.getEntity().getNom());

		return formateurDto;
	}

	@Transactional(readOnly = true)
	public FormateurDTO findById(FormateurDTO formateurDto) {
		Formateur formateur = formateurDto.getEntity();
		formateurDao.findById(formateur.getId());
		formateur = formateurDto.getEntity();
		formateur.setCreatedAt(LocalDate.now());
		formateur.setModifiedAt(LocalDate.now());
		return formateurDto;
	}

}
