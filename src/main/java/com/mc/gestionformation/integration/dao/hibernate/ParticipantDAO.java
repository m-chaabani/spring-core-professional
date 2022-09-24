package com.mc.gestionformation.integration.dao.hibernate;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mc.gestionformation.dto.ParticipantDTO;
import com.mc.gestionformation.integration.dao.IParticipantDAO;
import com.mc.gestionformation.model.Participant;



@Repository
public class ParticipantDAO implements IParticipantDAO {
	
	
	@Autowired
	SessionFactory sessionFactory;

	

	@Override
	public Participant create(Participant participant) {
		 Session session = sessionFactory.getCurrentSession();
	        session.persist(participant);
		return participant;
	}

	@Override
	public Participant update(Participant participant) {
		 Session session = sessionFactory.getCurrentSession();
	        session.persist(participant);
		return participant;
	}

	@Override
	public boolean delete(Participant participant) {
		 Session session = sessionFactory.getCurrentSession();
	        session.delete(participant);
		return true;
	}

	@Override
	public boolean deleteById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Optional<Participant> findById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		session
		.createQuery("from Participant p where p.id= ?")
		.setParameter(0, id)
		.uniqueResult();
		session.createQuery("FROM Person").list();
		return null;
	}

	@Override
	public Collection<Participant> findAll() {

		return null;
	}

	@Override
	public List<Participant> findMatriculeIn(String matricule, String... matricules) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Participant> findByAdresse(String adresse) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
