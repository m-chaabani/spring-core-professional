package com.mc.gestionformation.dao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataAccessException;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.mc.gestionformation.config.JdbcConfigTest;
import com.mc.gestionformation.dto.FormateurDTO;
import com.mc.gestionformation.integration.dao.jdbctemplate.FormateurDAOJdbcTemplate;
import com.mc.gestionformation.model.Formateur;

@SpringJUnitConfig(classes = { JdbcConfigTest.class })
public class FormateurDAOJdbcTemplateTest {

	private static final Long NOTEXISTING_FORMATEUR_ID = 999L;
	private static final Long SEARCHED_FORMATEUR_ID = 1L;
	@Autowired
	FormateurDAOJdbcTemplate daoJdbcTemplate;

	@Test
	public void FormateurDaoJdbcTemplate_1_FindAll_PositiveTest() {

		FormateurDTO dto = daoJdbcTemplate.findAll();
		assertNotNull(dto);
		List<Formateur> listFormateurs = dto.getFormateurs();
		assertNotNull(listFormateurs);
		assertEquals(listFormateurs.size(), 4);

	}

	@Test
	public void FormateurDaoJdbcTemplate_2_FindAll_NegativeTest() {
		fail("Not yet Implemented");
	}

	@Test
	public void FormateurDaoJdbcTemplate_3_FindByID_PositiveTest() {

		FormateurDTO dto = daoJdbcTemplate.findById(SEARCHED_FORMATEUR_ID);
		assertNotNull(dto);
		Formateur formateur = dto.getFormateur();
		assertNotNull(formateur);
		assertEquals(formateur.getPrenom(), "MOHAMED");
		assertEquals(formateur.getNom(), "BEN SALAH");

	}

	@Test
	public void FormateurDaoJdbcTemplate_4_FindByID_NegativeTest() {

		assertThrows(DataAccessException.class, () -> {
			daoJdbcTemplate.findById(NOTEXISTING_FORMATEUR_ID);
		});

	}

	@Test
	@Order(1)
	@Rollback(true)
	public void FormateurDaoJdbcTemplate_5_create_PositiveTest() {

		Formateur formateur = new Formateur();
		formateur.setId(5L);
		formateur.setNom("Test Create (NOM) ");
		formateur.setPrenom("Test Create (PRENOM) ");

		FormateurDTO dto = new FormateurDTO();
		dto.setFormateur(formateur);

		dto = daoJdbcTemplate.create(dto); // + Commit;
		assertNotNull(dto);
		assertFalse(dto.isHasErros());
		assertEquals(daoJdbcTemplate.count(), 5L);

	}

	@Test
	public void FormateurDaoJdbcTemplate_6_create_NegativeTest() {
		fail("Not yet Implemented");
	}

	@Test
	public void FormateurDaoJdbcTemplate_7_update_PositiveTest() {
		fail("Not yet Implemented");
	}

	@Test
	public void FormateurDaoJdbcTemplate_8_update_NegativeTest() {
		fail("Not yet Implemented");
	}

	@Test
	public void FormateurDaoJdbcTemplate_9_delete_PositiveTest() {
		fail("Not yet Implemented");
	}

	@Test
	public void FormateurDaoJdbcTemplate_10_delete_NegativeTest() {
		fail("Not yet Implemented");
	}

	@Test
	@Order(2)
	public void FormateurDaoJdbcTemplate_11_account_PositiveTest() {
		assertEquals(daoJdbcTemplate.count(), 4L);
	}

	@Test
	public void FormateurDaoJdbcTemplate_12_rowcallback() {
		String html = daoJdbcTemplate.getFormateurAsHtml(SEARCHED_FORMATEUR_ID);
		assertNotNull(html);
		System.out.println(html);
	}
	
	@Test
	public void FormateurDaoJdbcTemplate_13_ResultSetExtractor() {
		FormateurDTO dto  = daoJdbcTemplate.getFormateurFormation(SEARCHED_FORMATEUR_ID);
		assertNotNull(dto);
		System.out.println(dto);
	}

}
