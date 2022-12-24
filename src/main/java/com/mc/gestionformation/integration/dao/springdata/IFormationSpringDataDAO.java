package com.mc.gestionformation.integration.dao.springdata;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mc.gestionformation.integration.dao.IFormationDAO;
import com.mc.gestionformation.model.Formation;

@Repository
@Primary
public interface IFormationSpringDataDAO extends IFormationDAO, JpaRepository<Formation, Long> {
	@Override
	default Formation update(Formation entity) {
		this.save(entity);
		return entity;
	}
	@Override
	default Formation create(Formation entity) {
		this.save(entity);
		return entity;
	}
	
	
	

//	FormationDTO findFormationByFormateur(FormationDTO dto);
//	FormationDTO findFormationByDiscipline(FormationDTO dto);

}
