package com.mc.gestionformation.business;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mc.gestionformation.dto.ParticipantDTO;
import com.mc.gestionformation.model.Participant;

@Transactional(transactionManager = "jpaTransactionManager")
public interface IParticipantBusiness extends ICRUDBusiness<ParticipantDTO> {
	
	
	List<Participant> findMatriculeIn(String matricule, String... matricules);
	
	@Transactional(transactionManager = "jpaTransactionManager")
	List<Participant> findByAdresse(String adresse);

	ParticipantDTO create(ParticipantDTO dto);

	ParticipantDTO update(ParticipantDTO dto);

	boolean delete(ParticipantDTO dto);

	ParticipantDTO findById(ParticipantDTO dto);

	ParticipantDTO findAll(ParticipantDTO dto);

}
