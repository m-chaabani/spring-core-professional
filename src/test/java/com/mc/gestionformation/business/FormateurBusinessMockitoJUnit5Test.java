package com.mc.gestionformation.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mc.gestionformation.business.impl.FormateurBusiness;
import com.mc.gestionformation.dto.FormateurDTO;
import com.mc.gestionformation.integration.dao.IFormateurDAO;
import com.mc.gestionformation.model.Formateur;

@ExtendWith(MockitoExtension.class)
public class FormateurBusinessMockitoJUnit5Test {
	static final Long FORMATEUR_ID = 1L;

	@Mock
	private IFormateurDAO daoMock; // declaration

	@InjectMocks
	private FormateurBusiness formateurBusiness;

	@org.junit.jupiter.api.Test
	public void findByIdPositive() {
		// création du formateur à chercher
		FormateurDTO formateurDTO = new FormateurDTO();
		Formateur searchedFormateur = new Formateur();
		searchedFormateur.setId(FORMATEUR_ID);
		searchedFormateur.setNom("MOHAMED");
		searchedFormateur.setPrenom("BEN SALAH");
		formateurDTO.setEntity(searchedFormateur);
		Optional<Formateur> formateurResult = Optional.of(searchedFormateur);

		when(daoMock.findById(any(Long.class))).thenReturn(formateurResult); // (3)

		
		assertNull(formateurDTO.getEntity().getCreatedAt());
		FormateurDTO formateurDTOResult = formateurBusiness.findById(formateurDTO); // (4)

		assertNotNull(formateurDTOResult); // (5.1)
		assertNotNull(formateurDTOResult.getEntity());// (5.2)
		assertEquals("Name are not the same ! ", formateurDTO.getEntity().getNom(), "MOHAMED");// (5.2)
		assertNotNull(formateurDTOResult.getEntity().getCreatedAt());
		
		

	}

}
