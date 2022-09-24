package com.mc.gestionformation.integration.dao;

import java.util.List;
import java.util.Optional;

import com.mc.gestionformation.model.Discipline;

public interface IDisciplineDAO extends IDAO<Discipline> {
	
	Optional<Discipline> findByCode(String Code);

	List<Discipline> findByTitle(String title);
}
