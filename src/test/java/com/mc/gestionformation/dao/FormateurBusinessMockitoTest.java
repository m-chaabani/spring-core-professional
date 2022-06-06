package com.mc.gestionformation.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.mc.gestionformation.business.FormateurBusiness;
import com.mc.gestionformation.dto.FormateurDTO;
import com.mc.gestionformation.integration.dao.IFormateurDAO;
import com.mc.gestionformation.model.Formateur;

@RunWith(MockitoJUnitRunner.class)
//@ExtendWith(...) whith JUnit 5
public class FormateurBusinessMockitoTest {
	static final Long FORMATEUR_ID = 1L;

	@Mock
	private IFormateurDAO daoMock; // declaration

	@InjectMocks
	private FormateurBusiness formateurBusiness;

	@Test
	public void findByIdPositive() {
		// création du formateur à chercher
		FormateurDTO formateurDTO = new FormateurDTO();
		Formateur searchedFormateur = new Formateur();
		searchedFormateur.setId(FORMATEUR_ID);
		searchedFormateur.setNom("MOHAMED");
		searchedFormateur.setPrenom("BEN SALAH");
		formateurDTO.setFormateur(searchedFormateur);

		when(daoMock.findById(any(Long.class))).thenReturn(formateurDTO); // (3)

		
		assertNull(formateurDTO.getFormateur().getCreatedAt());
		FormateurDTO formateurDTOResult = formateurBusiness.findById(formateurDTO); // (4)

		assertNotNull(formateurDTOResult); // (5.1)
		assertNotNull(formateurDTOResult.getFormateur());// (5.2)
		assertEquals("Name are not the same ! ", formateurDTO.getFormateur().getNom(), "MOHAMED");// (5.2)
		assertNotNull(formateurDTOResult.getFormateur().getCreatedAt());
		
		

	}

}
