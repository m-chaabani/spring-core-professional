package com.mc.gestionformation.integration.dao;

import java.util.List;

import com.mc.gestionformation.model.Participant;

public interface IParticipantDAO extends IDAO<Participant> {

	List<Participant> findMatriculeIn(String matricule, String... matricules);
	List<Participant> findByAdresse(String adresse);
    
}
