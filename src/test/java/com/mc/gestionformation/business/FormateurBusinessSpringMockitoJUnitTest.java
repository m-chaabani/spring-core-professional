package com.mc.gestionformation.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;

import com.mc.gestionformation.business.FormateurBusiness;
import com.mc.gestionformation.config.AppConfig;
import com.mc.gestionformation.dto.FormateurDTO;
import com.mc.gestionformation.model.Formateur;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = AppConfig.class)
// @ActiveProfiles({"prod"}) // test integration 
//@ActiveProfiles({ "test" }) // test Unitaire
@SpringJUnitConfig()
public class FormateurBusinessSpringMockitoJUnitTest {

	static final Long FORMATEUR_ID = 1L;

	@ClassRule
	public static SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();

	@Rule
	public final SpringMethodRule springMethoRule = new SpringMethodRule();

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

	@Configuration
	static class DBConfigTest {
		@Bean
		Integer myID() {
			return 1;
		}
	}

}
