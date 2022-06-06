package com.mc.gestionformation.integration.dao;

import com.mc.gestionformation.dto.FormationDTO;

public interface IFormationDAO extends IDAO<FormationDTO>{
	
	FormationDTO findFormationByFormateur(FormationDTO dto);
	FormationDTO findFormationByDiscipline(FormationDTO dto);

}
