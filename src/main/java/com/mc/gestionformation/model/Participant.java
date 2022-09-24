package com.mc.gestionformation.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
		@NamedQuery(name = Participant.PARTICIPANT_FIND_LIKELY_ADDRESS, query = "from Participant p where p.adresse like :adresse"),
		@NamedQuery(name = Participant.PARTICIPANT_FIND_IN_MATRICULES, query = "from Participant p where p.matricule in ( :matricules ) "),
		@NamedQuery(name = Participant.PARTICIPANT_FIND_LIKELY_NOM, query = "from Participant p where p.adresse like :nom")
})
@Entity
public class Participant extends AbstractEntity {

	public static final String PARTICIPANT_FIND_LIKELY_ADDRESS = "participant_findLikelyAddress";
	public static final String PARTICIPANT_FIND_IN_MATRICULES = "participant_findInMatricules";
	public static final String PARTICIPANT_FIND_LIKELY_NOM = "participant_findLikeNom";

	private String matricule;
	private String nom;
	private String adresse;

	public Participant() {

	}

	public Participant(Long id) {
		super(id);
	}

	public Participant(Long id, String version, LocalDate createdAt, LocalDate modifiedAt, String matricule, String nom,
			String adresse) {
		super(id, version, createdAt, modifiedAt);
		this.matricule = matricule;
		this.nom = nom;
		this.adresse = adresse;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	@Override
	public String toString() {
		return "Participant [matricule=" + matricule + ", nom=" + nom + ", adresse=" + adresse + "]";
	}
	
	
	
}
