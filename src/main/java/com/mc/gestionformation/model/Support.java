package com.mc.gestionformation.model;

import java.time.LocalDate;

public class Support extends AbstractEntity {

	public enum TypeSupport {
		TXT, AUDIO, VIDEO, IMAGE
	}

	
	private TypeSupport typeSupport;
	private Byte[] contenu;
	private String link;

	private Formation formation;
	private Formateur formateur;

	public Support() {
		// TODO Auto-generated constructor stub
	}

	public Support(Long id, String version, LocalDate createdAt, LocalDate modifiedAt) {
		super(id, version, createdAt, modifiedAt);
		// TODO Auto-generated constructor stub
	}

	public TypeSupport getTypeSupport() {
		return typeSupport;
	}

	public void setTypeSupport(TypeSupport typeSupport) {
		this.typeSupport = typeSupport;
	}

	public Byte[] getContenu() {
		return contenu;
	}

	public void setContenu(Byte[] contenu) {
		this.contenu = contenu;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

}
