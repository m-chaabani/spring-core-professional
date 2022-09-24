package com.mc.gestionformation.business.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mc.gestionformation.business.AbstractCRUDBusiness;
import com.mc.gestionformation.business.IDisciplineBusiness;
import com.mc.gestionformation.dto.DisciplineDTO;
import com.mc.gestionformation.integration.dao.IDAO;
import com.mc.gestionformation.integration.dao.IDisciplineDAO;
import com.mc.gestionformation.model.Discipline;

@Service
public class DisciplineBusiness extends AbstractCRUDBusiness<DisciplineDTO> implements IDisciplineBusiness {

	private static Logger logger = LoggerFactory.getLogger(DisciplineBusiness.class);

	@Autowired
	IDisciplineDAO disciplineDAO;

	@Override
	protected IDAO getRepo() {
		return disciplineDAO;
	}

	@Override
	@Transactional
	public DisciplineDTO findById(DisciplineDTO dto) {

		super.findById(dto);
		return super.findById(dto);
	}

	@Override
	public DisciplineDTO findByCode(DisciplineDTO dto) {
		Optional<Discipline> result = disciplineDAO.findByCode(dto.getEntity().getCode());
		dto.setEntity(result.isEmpty() ? null : result.get());
		return dto;
	}

	@Override
	public DisciplineDTO findByTitle(DisciplineDTO dto) {
		List<Discipline> result = disciplineDAO.findByTitle(dto.getEntity().getIntitule());
		dto.setListEntity(result);
		return dto;
	}

}
