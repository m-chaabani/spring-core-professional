package com.mc.gestionformation.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mc.gestionformation.business.impl.FormateurBusiness;
import com.mc.gestionformation.config.AppConfig;
import com.mc.gestionformation.dto.FormateurDTO;
import com.mc.gestionformation.model.Formateur;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
// @ActiveProfiles({"prod"}) // test integration 
@ActiveProfiles({"test"})   // test Unitaire avec Stub
public class FormateurBusinessSpringJUnit4IntegrationTest_1 {
	static final Long FORMATEUR_ID = 1L;
	static final Long FORMATEUR_ID_NOTEXIST = 10L;

	@Autowired
	private FormateurBusiness formateurBusiness;

	@Test
	public void findByIdPositive() {
		// création du formateur à chercher
		FormateurDTO formateurDTO = new FormateurDTO();
		Formateur searchedFormateur = new Formateur();
		searchedFormateur.setId(FORMATEUR_ID);
		searchedFormateur.setNom("MOHAMED");
		searchedFormateur.setPrenom("BEN SALAH");
		formateurDTO.setEntity(searchedFormateur);

		assertNull(formateurDTO.getEntity().getCreatedAt());

		FormateurDTO formateurDTOResult = formateurBusiness.findById(formateurDTO);

		assertNotNull(formateurDTOResult); // (5.1)
		assertNotNull(formateurDTOResult.getEntity());// (5.2)
		assertEquals("Name are not the same ! ", formateurDTO.getEntity().getNom(), "MOHAMED");// (5.2)
		assertNotNull(formateurDTOResult.getEntity().getCreatedAt());

	}
	

	
	@Sql(statements = "insert into FORMATEUR_TEST (ID, FIRST_NAME, LAST_NAME) values (10,'MARIEM','BEN SALAH' );" )
	@Rollback(false)
	@Test(expected = NullPointerException.class)
	public void findByIdNegative() {
		// création du formateur à chercher
		FormateurDTO formateurDTO = new FormateurDTO();
		Formateur searchedFormateur = new Formateur();
		searchedFormateur.setId(FORMATEUR_ID_NOTEXIST);
		formateurDTO.setEntity(searchedFormateur);

		assertNull(formateurDTO.getEntity().getCreatedAt());

		FormateurDTO formateurDTOResult = formateurBusiness.findById(formateurDTO);

		assertNotNull(formateurDTOResult); // (5.1)
		assertNull(formateurDTOResult.getEntity());// (5.2)


	}



}
