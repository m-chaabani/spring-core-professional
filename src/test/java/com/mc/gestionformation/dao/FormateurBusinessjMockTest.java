package com.mc.gestionformation.dao;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;

import com.mc.gestionformation.business.FormateurBusiness;
import com.mc.gestionformation.dto.FormateurDTO;
import com.mc.gestionformation.integration.dao.IFormateurDAO;
import com.mc.gestionformation.model.Formateur;

public class FormateurBusinessjMockTest {
	
	static final Long FORMATEUR_ID = 1L;
	private IFormateurDAO daoMock; // (1) declaration
	private Mockery mockery = new JUnit4Mockery();// (2)
	private FormateurBusiness formateurBusiness;

	@Before
	public void setUp() {

		daoMock = mockery.mock(IFormateurDAO.class); // (3)
		// create object to be tested
		formateurBusiness = new FormateurBusiness(daoMock); // (4)

	}

	@Test
	public void findByIdPositive() {
		
		// cr�ation du formateur � chercher
		FormateurDTO formateurDTO = new FormateurDTO();
		Formateur searchedFormateur = new Formateur();
		searchedFormateur.setId(FORMATEUR_ID);
		searchedFormateur.setNom("MOHAMED");
		searchedFormateur.setPrenom("BEN SALAH");
		formateurDTO.setFormateur(searchedFormateur);

		mockery.checking(new Expectations() {
			{
				allowing(daoMock).findById(FORMATEUR_ID);
				will(returnValue(formateurDTO));
			}
		}); // (5)

		FormateurDTO formateurDTOResult = formateurBusiness.findById(formateurDTO); // (6)

		mockery.assertIsSatisfied(); // (7)

		assertNotNull(formateurDTOResult); // (8.1)
		assertNotNull(formateurDTOResult.getFormateur());// (8.2)
		assertEquals("Name are not the same ! ", formateurDTO.getFormateur().getNom(), "MOHAMED");// (8.2)

	}

}
