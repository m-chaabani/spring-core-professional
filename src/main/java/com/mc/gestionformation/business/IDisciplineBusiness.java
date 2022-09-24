package com.mc.gestionformation.business;

import org.springframework.transaction.annotation.Transactional;

import com.mc.gestionformation.dto.DisciplineDTO;

@Transactional
public interface IDisciplineBusiness extends ICRUDBusiness<DisciplineDTO> {

	DisciplineDTO findByCode(DisciplineDTO dto);

	DisciplineDTO findByTitle(DisciplineDTO dto);
}
