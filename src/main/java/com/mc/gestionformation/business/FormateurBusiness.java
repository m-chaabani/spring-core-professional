package com.mc.gestionformation.business;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.mc.gestionformation.dto.FormateurDTO;
import com.mc.gestionformation.integration.dao.IFormateurDao;
import com.mc.gestionformation.model.Formateur;
import com.mc.gestionformation.service.IFormateurService;

@Service
@Primary
public class FormateurBusiness implements IFormateurService, InitializingBean, DisposableBean {
	private static Logger logger = LoggerFactory.getLogger(FormateurBusiness.class);

	public List<Formateur> allFormateurs;

	private IFormateurDao formateurDao = null;

	public FormateurBusiness() {
		logger.info("1. Construction by no-arg constructor");
//		FormateurDTO dto = formateurDao.findAll();
//		allFormateurs = dto.getFormateurs();
//		// le resultat est NPE
	}

	public IFormateurDao getFormateurDao() {
		return formateurDao;
	}

	@Autowired
	public void setFormateurDao(@Qualifier("formateurDaoJDBC") IFormateurDao formateurDao) {
		logger.info("2. DAO Dependecy injected");
		this.formateurDao = formateurDao;
	}

	// @Autowired
	public FormateurBusiness(@Qualifier("formateurDaoJDBC") IFormateurDao formateurDao) {
		super();
		this.formateurDao = formateurDao;
		FormateurDTO dto = formateurDao.findAll();
		allFormateurs = dto.getFormateurs();
	}

	@Override
	public FormateurDTO enregistrer(FormateurDTO formateurDto) {
		logger.info("in business.enregistrer() ...");
		Formateur formateur = formateurDto.getFormateur();
		formateur.setCreatedAt(LocalDate.now());
		formateur.setModifiedAt(LocalDate.now());
		formateurDto = (FormateurDTO) formateurDao.create(formateurDto);
		return formateurDto;
	}

	@PostConstruct
	private void initialisation() {
		logger.info("3. initialisation @PostConstruct");
		FormateurDTO dto = formateurDao.findAll();
		allFormateurs = dto.getFormateurs();

	}

	@PostConstruct
	private void initialisation2() {
		logger.info("3. initialisation2 @PostConstruct");

	}

	@PostConstruct
	private void initialisation3() {
		logger.info("3. initialisation3 @PostConstruct");

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		logger.info("3. initialisation with afterPropertiesSet");
		FormateurDTO dto = formateurDao.findAll();
		allFormateurs = dto.getFormateurs();

	}

	@PreDestroy
	private void destruction() {
		logger.info("4. destruction resources in FormateurBusiness before deletion");

	}

	@Override
	public void destroy() throws Exception {
		logger.info("4. destroy DispoableBean resources in FormateurBusiness before deletion");

	}

}
