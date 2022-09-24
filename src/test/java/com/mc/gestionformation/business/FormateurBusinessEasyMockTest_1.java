package com.mc.gestionformation.business;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.core.annotation.Order;

import com.mc.gestionformation.business.impl.FormateurBusiness;
import com.mc.gestionformation.dto.FormateurDTO;
import com.mc.gestionformation.integration.dao.IFormateurDAO;
import com.mc.gestionformation.model.Formateur;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FormateurBusinessEasyMockTest_1 {

	IFormateurDAO mockDao;// (1)
	FormateurBusiness formateurBusines;

	@Before
	public void init() {
		mockDao = createMock(IFormateurDAO.class); // (2)
		formateurBusines = new FormateurBusiness(mockDao); // (3)
	}

	@Test
	public void _1_createTestPositive() {

		// Input
		FormateurDTO formateurDtoInPutMock = new FormateurDTO();
		Formateur formateurInput = new Formateur();
		formateurInput.setNom("Test");
		formateurInput.setPrenom("Test");
		formateurDtoInPutMock.setEntity(formateurInput);
		// fin Input

		assertNull(formateurInput.getCreatedAt());
		assertNull(formateurInput.getModifiedAt());

		expect(mockDao.create(formateurInput)).andReturn(formateurInput);// (4)
		replay(mockDao); // (5)

		FormateurDTO formateurDtoResultBusiness = formateurBusines.enregistrer(formateurDtoInPutMock); // (6)

		verify(mockDao); // (7)

		assertNotNull(formateurDtoResultBusiness);
		assertNotNull(formateurDtoResultBusiness.getEntity());
		System.out.println(formateurDtoResultBusiness.getEntity().getCreatedAt());
		System.out.println(formateurDtoResultBusiness.getEntity().getModifiedAt());
		assertNotNull(formateurDtoResultBusiness.getEntity().getCreatedAt());
		assertNotNull(formateurDtoResultBusiness.getEntity().getModifiedAt());

	}

	@Test(expected = IllegalArgumentException.class)
	@Ignore
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
