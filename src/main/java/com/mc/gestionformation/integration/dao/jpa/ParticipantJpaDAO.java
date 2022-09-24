package com.mc.gestionformation.integration.dao.jpa;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.query.NativeQuery;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.mc.gestionformation.integration.dao.IParticipantDAO;
import com.mc.gestionformation.model.Participant;

@Repository
@Scope(scopeName = "prototype")
public class ParticipantJpaDAO implements IParticipantDAO {

//	@Autowired
//	SessionFactory sessionFactory;

	@PersistenceContext(unitName = "entityManagerFactory")
	EntityManager entityManager;

	@Override
	public Participant create(Participant participant) {
		entityManager.persist(participant);
		return participant;
	}

	@Override
	public Participant update(Participant participant) {
		entityManager.merge(participant);
		return participant;
	}

	@Override
	public boolean delete(Participant participant) {
		entityManager.remove(participant);
		return true;
	}

	@Override
	public boolean deleteById(Long id) {
		entityManager.remove(new Participant(id));
		return true;
	}

	@Override
	public Optional<Participant> findById(Long id) {
		Participant resultat = entityManager.find(Participant.class, id);
		return Optional.ofNullable(resultat);
	}

	@Override
	public Collection<Participant> findAll() {
		Query query = entityManager.createQuery("from Participant");
		List<Participant> resultat = query.getResultList();

		return resultat;
	}

	@Override
	public List<Participant> findMatriculeIn(String matricule, String... matricules) {
		
//		String listMatricule = matricule;
//		for (String s : matricules)
//			listMatricule += "," + s;
//		Query query = entityManager.createQuery("from Participant p where p.matricule in ( " + listMatricule + " ) ");

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Participant> criteriaQuery = builder.createQuery(Participant.class);
		Root<Participant> root = criteriaQuery.from(Participant.class);
		criteriaQuery.select(root).where(root.get("matricule").in(matricules));

		TypedQuery<Participant> tq = entityManager.createQuery(criteriaQuery);

		return tq.getResultList();

	}

	@Override
	public List<Participant> findByAdresse(String adresse) {

		// NativeQuery (SQL)
		NativeQuery nativeQuery = (NativeQuery) entityManager.createNativeQuery("Select * from Participant where 1=1");

		// Query (JPQL)
		Query query = entityManager.createQuery("from Participant p where p.adresse like %:adresse% ");
		query.setParameter("adresse", adresse);

		// NamedQuery
		query = entityManager.createNamedQuery(Participant.PARTICIPANT_FIND_LIKELY_ADDRESS);
		query.setParameter("adresse", adresse);

		return query.getResultList();
	}

}
