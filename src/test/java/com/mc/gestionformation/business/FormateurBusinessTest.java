package com.mc.gestionformation.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.core.annotation.Order;

import com.mc.gestionformation.dto.FormateurDTO;
import com.mc.gestionformation.integration.dao.inmem.FormateurDaoInMemory;
import com.mc.gestionformation.model.Formateur;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FormateurBusinessTest {

	FormateurBusiness formateurBusines;

	@Before
	public void init() {

		System.out.println("Before ");
		formateurBusines = new FormateurBusiness(new FormateurDaoInMemory());
	}

	@Test
	public void _1_createTestPositive() {

		FormateurDTO formateurDto = new FormateurDTO();
		Formateur formateur = new Formateur();
		formateur.setNom("Test");
		formateur.setPrenom("Test");
		formateurDto.setEntity(formateur);

		FormateurDTO formateurDtoResult = formateurBusines.enregistrer(formateurDto);
		assertNotNull(formateurDtoResult);
		assertNotNull(formateur = formateurDtoResult.getEntity());
	     long id = (long)formateur.getId();
		assertEquals(6, id);

		                      
	}

	@Test(expected = IllegalArgumentException.class)
	public void _4_createTestNegative() {
		throw new IllegalArgumentException(); 
	}

	@Test
	@Order(2)
	@Ignore
	public void _3_updateTestPositive() {
		fail("not yet implemented");
	}

	@Test
	@Order(3)
	@Ignore
	public void _2_updateTestNegative() {
		fail("not yet implemented");
	}

	@After
	public void finishStep() {
		System.out.println("After ");
	}

}
