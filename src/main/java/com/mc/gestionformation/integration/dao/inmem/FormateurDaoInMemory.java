package com.mc.gestionformation.integration.dao.inmem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.mc.gestionformation.dto.FormateurDTO;
import com.mc.gestionformation.dto.FormateurDTOMapper;
import com.mc.gestionformation.dto.FormateurDTOMapperImpl;
import com.mc.gestionformation.integration.dao.IFormateurDAO;
import com.mc.gestionformation.model.Discipline;
import com.mc.gestionformation.model.Formateur;

@Repository
@Profile("test-unitaire")
public class FormateurDaoInMemory implements IFormateurDAO {

	private Map<Long, Formateur> FORMATEURS = new HashMap<Long, Formateur>();
	private Map<Discipline, List<Formateur>> DISCIPLINE_FORMATEUR = new HashMap<Discipline, List<Formateur>>();

	private FormateurDTOMapper formateurMapper = new FormateurDTOMapperImpl();

	{
		init_formateurs: for (long i = 1; i <= 5; i++) {

			Formateur formateur = new Formateur();
			formateur.setId(i);
			formateur.setNom("Nom de " + i);
			formateur.setPrenom("Prenom de " + i);
			FORMATEURS.put(i, formateur);

		}

		init_disciplines: for (long i = 1; i <= 3; i++) {
			Discipline discipline = new Discipline();
			discipline.setId(i);
			discipline.setCode("D" + i);
			discipline.setLibelle("DISCIPLINE ..." + i);
//			if (i == 1) {
//				DISCIPLINE_FORMATEUR.put(discipline, List.of(FORMATEURS.get(1), FORMATEURS.get(2)));
//			}
//			if (i == 2) {
//				DISCIPLINE_FORMATEUR.put(discipline, List.of(FORMATEURS.get(3), FORMATEURS.get(4)));
//			}
//			if (i == 3) {
//				DISCIPLINE_FORMATEUR.put(discipline, List.of(FORMATEURS.get(5)));
//			}

		}

	}

	@Override
	public Formateur create(Formateur formateur) {

		long nextIndice = FORMATEURS.size() + 1;
		formateur.setId((long) (nextIndice));
		FORMATEURS.put(nextIndice, formateur);
		return formateur;

	}

	@Override
	public Formateur update(Formateur formateur) {

		FORMATEURS.put(formateur.getId(), formateur);
		return formateur;

	}

	@Override
	public boolean delete(Formateur formateur) {

		Object f =  FORMATEURS.remove(formateur.getId());
		return (f!=null);
	}

	@Override
	public Optional<Formateur> findById(Long id) {
		Formateur formateur = FORMATEURS.get(id);
		return  Optional.ofNullable(formateur) ;

	}

	@Override
	public List<Formateur> findAll() {
		List<Formateur> formateurs = new ArrayList(FORMATEURS.values());
		return formateurs;

	}

	@Override
	public boolean deleteById(Long id) {
		Object f =  FORMATEURS.remove(id);
		return (f!=null);
	}

	@Override
	public FormateurDTO findByDiscipline(FormateurDTO dto) {

		Discipline discipline = dto.getDiscipline();
		dto.setListEntity(DISCIPLINE_FORMATEUR.get(discipline));

		return dto;
	}

}
