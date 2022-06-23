package com.mc.gestionformation.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import com.mc.gestionformation.dto.ParticipantDTO;
import com.mc.gestionformation.integration.dao.IParticipantDAO;

@Service("ParticipantBusinessProgramaticTransaction")
public class ParticipantBusiness {

	IParticipantDAO participant;

	TransactionTemplate txTempalte;

	@Autowired
	public ParticipantBusiness(IParticipantDAO participant, PlatformTransactionManager txManager) {
		this.participant = participant;
		txTempalte = new TransactionTemplate(txManager);
	}

	public ParticipantDTO createParticipant(ParticipantDTO participantDto) {

		txTempalte.execute(status -> {
			try {
				// appel au DAO pour enregistrer
			} catch (Exception e) {
				status.setRollbackOnly();
			}

			return participantDto;
		});
		return null;
	}

}
