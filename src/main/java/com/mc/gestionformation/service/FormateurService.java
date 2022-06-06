package com.mc.gestionformation.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mc.gestionformation.aspect.Loggable;
import com.mc.gestionformation.dto.FormateurDTO;

@Service
public class FormateurService implements IFormateurService {
	private static Logger logger = LoggerFactory.getLogger(FormateurService.class);
	IFormateurService formateurBusiness; // = new FormateurBusiness(); pour diminuer le couplage on éliminie
											// l'instanciation

	public FormateurService() {
		logger.info("[bean creation from FormateurService with 0-arg constructor]");
	}

	@Autowired
	public FormateurService(IFormateurService formateurBusiness) {
		super();
		this.formateurBusiness = formateurBusiness;
		logger.info("[bean creation from FormateurService with 1-arg constructor]");
	}

	@Override
	@Loggable
	public FormateurDTO enregistrer(FormateurDTO formateurDto) {
		try {
			// journalisation
            //			logger.info("  IN SERIVICE ..."); // --> remplacer par la journalisation en AOP
			// ajout de l'aspet caching
			cache();
			// ajout de l'aspet transaction
			ouvrirTransaction();
			// ajout de l'aspet securité
			if (estAutorise()) {
				formateurDto = formateurBusiness.enregistrer(formateurDto);
			}
			fermerTransaction();
		} catch (Exception e) {
			journalisation(e);
			throw e;
		}

		return formateurDto;
	}

	private void journalisation(Exception e) {

		System.out.println("je fais la jounalisation ");
	}

	private void cache() {
		// utilisation de REDIS, HASHMAP, ...
		System.out.println(" caching  ...");

	}

	private boolean estAutorise() {
		System.out.println(" vérification des autorisations ...");
		System.out.println(" Utilisateur autorisé ...");

		return true;
	}

	private void ouvrirTransaction() {
		System.out.println(" Transaction Ouverte ...");
	}

	private void fermerTransaction() {
		System.out.println(" Transaction fermée ...");

	}

}
