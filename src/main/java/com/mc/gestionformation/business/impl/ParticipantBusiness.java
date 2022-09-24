package com.mc.gestionformation.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mc.gestionformation.business.AbstractCRUDBusiness;
import com.mc.gestionformation.business.IParticipantBusiness;
import com.mc.gestionformation.dto.ParticipantDTO;
import com.mc.gestionformation.integration.dao.IDAO;
import com.mc.gestionformation.integration.dao.IParticipantDAO;
import com.mc.gestionformation.model.Participant;

@Service("ParticipantBusinessProgramaticTransaction")
@Transactional(transactionManager = "jpaTransactionManager")
public class ParticipantBusiness extends AbstractCRUDBusiness<ParticipantDTO> implements IParticipantBusiness {

	@Autowired
	@Qualifier("participantJpaDAO")
	IParticipantDAO participantDao;

//	TransactionTemplate txTempalte;

//	@Autowired
//	public ParticipantBusiness(IParticipantDAO participant, PlatformTransactionManager txManager) {
//		this.participant = participant;
//		txTempalte = new TransactionTemplate(txManager);
//	}
//
//	public ParticipantDTO createParticipant(ParticipantDTO participantDto) {
//
//		txTempalte.execute(status -> {
//			try {
//				// appel au DAO pour enregistrer
//			} catch (Exception e) {
//				status.setRollbackOnly();
//			}
//
//			return participantDto;
//		});
//		return null;
//	}

	@Override
	protected IDAO getRepo() {
		return participantDao;
	}

	@Override
	@Transactional(transactionManager = "jpaTransactionManager")
	public List<Participant> findMatriculeIn(String matricule, String... matricules) {
		
		return participantDao.findMatriculeIn(matricule, matricules);
	}

	@Override
	@Transactional(transactionManager = "jpaTransactionManager")
	public List<Participant> findByAdresse(String adresse) {
		return participantDao.findByAdresse(adresse);
	}

}
