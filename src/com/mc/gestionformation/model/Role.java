package com.mc.gestionformation.model;

import java.time.LocalDate;

public class Role extends AbstractEntity {

	private String code;
	private String libelle;

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Role() {
	}

	public Role(Long id, String version, LocalDate createdAt, LocalDate modifiedAt) {
		super();
		super.setId(id);
		// super(id, version, createdAt, modifiedAt);
		// TODO Auto-generated constructor stub
	}

}
