package com.mc.gestionformation.dbContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestDBConfig.class })
public class RepositoryTest {
    
	// positive test, we know that a Person with ID=1 exists
	@Test
	public void findByIdPositive() {
//		FormateurDTO person = formateurDAO.findById(PERSON_ID);
//		assertNotNull(person);
//		assertEquals("Sherlock", person.getFirstName());
	}

}
