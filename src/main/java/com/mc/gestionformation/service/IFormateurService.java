package com.mc.gestionformation.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mc.gestionformation.business.ICRUDBusiness;
import com.mc.gestionformation.dto.FormateurDTO;
import com.mc.gestionformation.model.Formateur;

@Transactional(propagation = Propagation.REQUIRED, transactionManager = "dataSourceTransactionManager")
public interface IFormateurService {

	public FormateurDTO enregistrer(FormateurDTO formateurDto);

}
