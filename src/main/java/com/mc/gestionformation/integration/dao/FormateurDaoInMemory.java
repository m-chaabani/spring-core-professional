package com.mc.gestionformation.integration.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.mc.gestionformation.dto.FormateurDTO;
import com.mc.gestionformation.dto.FormateurDTOMapper;
import com.mc.gestionformation.dto.FormateurDTOMapperImpl;
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
	public FormateurDTO create(FormateurDTO formateurDTO) {

		long nextIndice = FORMATEURS.size() + 1;
		Formateur formateur = formateurMapper.DTOToformateur(formateurDTO);
		formateur.setId((long) (nextIndice));
		FORMATEURS.put(nextIndice, formateur);
		return formateurMapper.formateurToDTO(formateur);

	}

	@Override
	public FormateurDTO update(FormateurDTO formateurDTO) {

		Formateur formateur = formateurMapper.DTOToformateur(formateurDTO);
		FORMATEURS.put(formateur.getId(), formateur);
		return formateurMapper.formateurToDTO(formateur);

	}

	@Override
	public FormateurDTO delete(FormateurDTO formateurDTO) {
		Formateur formateur = formateurMapper.DTOToformateur(formateurDTO);
		FORMATEURS.remove(formateur.getId());
		return formateurMapper.formateurToDTO(formateur);
	}

	@Override
	public FormateurDTO findById(Long id) {

		Formateur formateur = FORMATEURS.get(id);
		return formateurMapper.formateurToDTO(formateur);

	}

	@Override
	public FormateurDTO findAll() {
		List<Formateur> formateurs = new ArrayList(FORMATEURS.values());
		FormateurDTO dto = new FormateurDTO();
		dto.setFormateurs(formateurs);
		return dto;

	}

	@Override
	public FormateurDTO deleteById(Long id) {

		FORMATEURS.remove(id);
		FormateurDTO dto = new FormateurDTO();
		return dto;
	}

	@Override
	public FormateurDTO findByDiscipline(FormateurDTO dto) {
		
		Discipline discipline = dto.getDiscipline();
		dto.setFormateurs(DISCIPLINE_FORMATEUR.get(discipline));

		return dto;
	}

}
