package com.mc.gestionformation.business.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mc.gestionformation.business.IParticipantBusiness;
import com.mc.gestionformation.dto.ParticipantDTO;
import com.mc.gestionformation.integration.dao.springdata.IParticipantSpringDataDAO;
import com.mc.gestionformation.model.Participant;

@Service("ParticipantBusinessSpringData")
@Transactional(transactionManager = "jpaTransactionManager")
public class ParticipantBusinessSpringData implements IParticipantBusiness {

	@Autowired
	IParticipantSpringDataDAO participantDao;

	@Override
	public List<Participant> findMatriculeIn(String matricule, String... matricules) {
				return participantDao.findMatriculeIn(matricules);
	}

	@Override
	public List<Participant> findByAdresse(String adresse) {
		return participantDao.findByAdresse(adresse);
	}

	@Override
	public ParticipantDTO create(ParticipantDTO dto) {
		 participantDao.save(dto.getEntity());
		return dto;
	}

	@Override
	public ParticipantDTO update(ParticipantDTO dto) {
		 participantDao.save(dto.getEntity());
		return null;
	}

	@Override
	public void delete(ParticipantDTO dto) {
		 participantDao.delete(dto.getEntity());
	}

	@Override
	public ParticipantDTO findById(ParticipantDTO dto) {
		Optional<Participant> result = participantDao.findById(dto.getEntity().getId());
		dto.setEntity(result.isEmpty()?null:result.get()); 
		return dto;
	}

	@Override
	public ParticipantDTO findAll(ParticipantDTO dto) {
		dto.setListEntity(participantDao.findAll());
		return dto ;
	}



}
