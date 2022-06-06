package com.mc.gestionformation.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.mc.gestionformation.dto.FormateurDTO;
import com.mc.gestionformation.integration.dao.FormateurDaoJDBC;
import com.mc.gestionformation.model.Formateur;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = AppConfig.class)
@ContextConfiguration(locations = {"classpath:spring/all-config.xml"}) 
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FormateurDaoJDBCTestCase {

	@Autowired
	FormateurDaoJDBC formateurDao;

	FormateurDTO dto;

	static private int nombreFormateur;

	@Before
	public void setUp() {
		System.out.println("setup");
		dto = new FormateurDTO();

	}

	@After
	public void tearDown() {
		System.out.println("tearDown");

	}
	
	@Test
	public void test0FindAllBeforeAll() {
		test3Delete();
		dto  = formateurDao.findAll(); 
		assertFalse(dto.isHasErros());
		nombreFormateur = dto.getFormateurs().size() ;
		System.out.println(" test0FindAllBeforeAll " + nombreFormateur);
	}

	@Test
	public void test1Create() {
		
		Formateur formateur = new Formateur("test_fn", "test_ln");
		formateur.setId(0L);
		dto.setFormateur(formateur);
		dto = formateurDao.create(dto);
		assertFalse(dto.isHasErros());
	}

	@Test
	public void test2FindAllAfterCreation() {
		dto  = formateurDao.findAll(); 
		assertFalse(dto.isHasErros());
		assertEquals(dto.getFormateurs().size(),(nombreFormateur + 1));
	
	}

	@Test
	public void test3Delete() {
		Formateur formateur = new Formateur(0L);
		dto.setFormateur(formateur);
		dto = formateurDao.delete(dto);
		assertFalse(dto.isHasErros());
		
	}

	@Test
	public void test4FindAllAfterDeletion() {
		dto  = formateurDao.findAll(); 
		assertFalse(dto.isHasErros());
		assertEquals(dto.getFormateurs().size(), nombreFormateur );
	}

}


