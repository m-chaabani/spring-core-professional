package com.mc.gestionformation.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mc.gestionformation.business.FormateurBusiness;
import com.mc.gestionformation.config.AppConfig;
import com.mc.gestionformation.dto.FormateurDTO;
import com.mc.gestionformation.model.Formateur;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
// @ActiveProfiles({"prod"}) // test integration 
@ActiveProfiles({"test"})   // test Unitaire avec Stub
public class FormateurBusinessSpringJUnit4IntegrationTest {
	static final Long FORMATEUR_ID = 1L;
	static final Long FORMATEUR_ID_NOTEXIST = 10L;

	@Autowired
	private FormateurBusiness formateurBusiness;

	@Test
	public void findByIdPositive() {
		// cr�ation du formateur � chercher
		FormateurDTO formateurDTO = new FormateurDTO();
		Formateur searchedFormateur = new Formateur();
		searchedFormateur.setId(FORMATEUR_ID);
		searchedFormateur.setNom("MOHAMED");
		searchedFormateur.setPrenom("BEN SALAH");
		formateurDTO.setFormateur(searchedFormateur);

		assertNull(formateurDTO.getFormateur().getCreatedAt());

		FormateurDTO formateurDTOResult = formateurBusiness.findById(formateurDTO);

		assertNotNull(formateurDTOResult); // (5.1)
		assertNotNull(formateurDTOResult.getFormateur());// (5.2)
		assertEquals("Name are not the same ! ", formateurDTO.getFormateur().getNom(), "MOHAMED");// (5.2)
		assertNotNull(formateurDTOResult.getFormateur().getCreatedAt());

	}
	

	
	@Sql(statements = "insert into FORMATEUR_TEST (ID, FIRST_NAME, LAST_NAME) values (10,'MARIEM','BEN SALAH' );" )
	@Rollback(false)
	@Test(expected = NullPointerException.class)
	public void findByIdNegative() {
		// cr�ation du formateur � chercher
		FormateurDTO formateurDTO = new FormateurDTO();
		Formateur searchedFormateur = new Formateur();
		searchedFormateur.setId(FORMATEUR_ID_NOTEXIST);
		formateurDTO.setFormateur(searchedFormateur);

		assertNull(formateurDTO.getFormateur().getCreatedAt());

		FormateurDTO formateurDTOResult = formateurBusiness.findById(formateurDTO);

		assertNotNull(formateurDTOResult); // (5.1)
		assertNull(formateurDTOResult.getFormateur());// (5.2)


	}



}
