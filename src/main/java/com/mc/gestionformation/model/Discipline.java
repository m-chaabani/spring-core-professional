package com.mc.gestionformation.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Discipline extends AbstractEntity {

	private String code;
	private String libelle;
	
	private Set<Formation> formations = new HashSet<>();
	
	
	
	public Discipline() {
		// TODO Auto-generated constructor stub
	}

	public Discipline(Long id, String version, LocalDate createdAt, LocalDate modifiedAt) {
		super(id, version, createdAt, modifiedAt);
		// TODO Auto-generated constructor stub
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Set<Formation> getFormations() {
		return formations;
	}

	public void setFormations(Set<Formation> formations) {
		this.formations = formations;
	}

}
