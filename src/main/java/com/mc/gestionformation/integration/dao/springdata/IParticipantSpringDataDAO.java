package com.mc.gestionformation.integration.dao.springdata;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mc.gestionformation.model.Participant;

public interface IParticipantSpringDataDAO extends JpaRepository<Participant, Long> {
	
	@Query(name = Participant.PARTICIPANT_FIND_LIKELY_ADDRESS)
	public List<Participant> findByAdresse(@Param("adresse")   String adresse);

	@Query(name = Participant.PARTICIPANT_FIND_IN_MATRICULES)
	List<Participant> findMatriculeIn(@Param("matricules") String... matricules);
}
