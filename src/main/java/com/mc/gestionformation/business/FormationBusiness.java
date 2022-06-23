package com.mc.gestionformation.business;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mc.gestionformation.dto.FormateurDTO;
import com.mc.gestionformation.dto.FormationDTO;
import com.mc.gestionformation.integration.dao.IDAO;
import com.mc.gestionformation.integration.dao.IFormationDAO;
import com.mc.gestionformation.model.Formation;
import com.mc.gestionformation.service.IFormateurService;

@Service("formationBusiness")
@Transactional(transactionManager = "dataSourceTransactionManager")
public class FormationBusiness extends AbstractCRUDBusiness<FormationDTO> implements IFormationService {

	private static Logger logger = LoggerFactory.getLogger(FormationBusiness.class);

	IFormateurService formateurBusiness;
	IFormationDAO formationDao;

	@Autowired
	public FormationBusiness(@Qualifier("formateurBusiness") IFormateurService formateurBusiness,
			IFormationDAO formationDao) {
		super();
		this.formateurBusiness = formateurBusiness;
		this.formationDao = formationDao;
		logger.info("[bean creation from FormationBusiness with 2-arg constructor]");
	}

	public FormationDTO enregistrer(FormationDTO formationDto) {

		// creation formateur
		FormateurDTO formateurDTO = new FormateurDTO();
		formateurDTO.setEntity(formationDto.getFormateur());
		formateurDTO = (FormateurDTO) formateurBusiness.enregistrer(formateurDTO);

		// creation formation
		Formation formation = formationDto.getFormation();
		formation.setCreatedAt(LocalDate.now());
		formation.setModifiedAt(LocalDate.now());
		;
		formationDto.setEntity(formationDao.create(formationDto.getEntity()));

		return formationDto;
	}

	public FormationDTO findById(FormationDTO formateurDto) {
		return formateurDto;
	}

	@Override
	IDAO<Formation> getRepo() {
		return formationDao;
	}

}
