package com.mc.gestionformation.integration.dao.jpa;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.mc.gestionformation.integration.dao.IDAO;
import com.mc.gestionformation.model.AbstractEntity;
import com.mc.gestionformation.model.Participant;

public abstract class CRUDJpaDAO<T extends AbstractEntity, Long> implements  IDAO<AbstractEntity> {
	
	abstract EntityManager getEntityManager();
	
	public Participant create(Participant participant) {
		getEntityManager().persist(participant);
		return participant;
	}

	@Override
	public AbstractEntity update(AbstractEntity participant) {
		getEntityManager().persist(participant);
		return participant;
	}

	@Override
	public void delete(AbstractEntity participant) {
		getEntityManager().remove(participant);

	}

//	@Override
//	public boolean deleteById(Long id) {
//		getEntityManager().remove(new Participant(id));
//		return true;
//	}
//
//	@Override
//	public Optional<AbstractEntity> findById(Long id) {
//		Participant resultat = getEntityManager().find(Participant.class, id);
//		return Optional.ofNullable(resultat);
//	}

}
