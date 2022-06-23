package com.mc.gestionformation.model;

import javax.persistence.Entity;

@Entity
public class Participant extends AbstractEntity {
	
	private String nom;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
