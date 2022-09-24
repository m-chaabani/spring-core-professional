package com.mc.gestionformation.business;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import com.mc.gestionformation.business.impl.FormateurBusiness;
import com.mc.gestionformation.dto.FormateurDTO;
import com.mc.gestionformation.integration.dao.IFormateurDAO;
import com.mc.gestionformation.model.Formateur;

public class FormateurBusinessEasyMockTest {
	static final Long FORMATEUR_ID = 1L;
	private IFormateurDAO daoMock; // declaration
	private FormateurBusiness formateurBusiness;

	@Before
	public void setUp() {

		daoMock = createMock(IFormateurDAO.class); // (2)
		// create object to be tested
		formateurBusiness = new FormateurBusiness(daoMock); // (3)

	}

	@Test
	public void findByIdPositive() {
		// création du formateur à chercher
		FormateurDTO formateurDTO = new FormateurDTO();
		Formateur searchedFormateur = new Formateur();
		searchedFormateur.setId(FORMATEUR_ID);
		searchedFormateur.setNom("MOHAMED");
		searchedFormateur.setPrenom("BEN SALAH");
		formateurDTO.setEntity(searchedFormateur);
		Optional<Formateur> resultFormateur = Optional.of(searchedFormateur);
		expect(daoMock.findById(FORMATEUR_ID)).andReturn(resultFormateur); // (4)
		replay(daoMock); // (5)
		formateurDTO = formateurBusiness.findById(formateurDTO); // (6)
		verify(daoMock); // (7)
		assertNotNull(formateurDTO); // (8.1)
		assertNotNull(formateurDTO.getEntity());// (8.2)
		assertEquals("Name are not the same ! ", formateurDTO.getEntity().getNom(), "MOHAMED");// (8.2)

		
		
	}

}
