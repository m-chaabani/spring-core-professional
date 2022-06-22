package com.mc.gestionformation.integration.dao;

import com.mc.gestionformation.dto.FormationDTO;
import com.mc.gestionformation.model.Formation;

public interface IFormationDAO extends IDAO<Formation>{
	
	FormationDTO findFormationByFormateur(FormationDTO dto);
	FormationDTO findFormationByDiscipline(FormationDTO dto);

}
