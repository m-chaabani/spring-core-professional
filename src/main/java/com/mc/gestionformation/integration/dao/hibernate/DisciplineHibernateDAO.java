package com.mc.gestionformation.integration.dao.hibernate;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mc.gestionformation.integration.dao.IDisciplineDAO;
import com.mc.gestionformation.model.Discipline;

@Repository
public class DisciplineHibernateDAO implements IDisciplineDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Discipline create(Discipline entity) {
		Session session = sessionFactory.getCurrentSession();
		session.save(entity);
		return entity;
	}

	@Override
	public Discipline update(Discipline entity) {
		Session session = sessionFactory.getCurrentSession();
		session.update(entity);
		return entity;
	}

	@Override
	public boolean delete(Discipline entity) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(entity);
		return true;
	}

	@Override
	public boolean deleteById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Discipline d = new Discipline();
		d.setId(id);
		session.delete(d);
		return false;
	}

	@Override
	public Optional<Discipline> findById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		//Discipline result = session.load(Discipline.class, id);
		Discipline result = session.get(Discipline.class, id);
		return (result == null) ? Optional.empty():Optional.of(result) ;
	}

	@Override
	public Collection<Discipline> findAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Discipline").list();
	}

	@Override
	public Optional<Discipline> findByCode(String Code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Discipline> findByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
