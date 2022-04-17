package com.mc.gestionformation.model;

public class Formateur extends AbstractEntity {

	private String nom;
	private String prenom;
	private Utilisateur user;

	public Formateur() {
	}

	public Formateur(Long id) {
		this.id = id;

	}

	public Formateur(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Formateur [nom=" + nom + ", prenom=" + prenom + ", user=" + user + ", id=" + id + ", createdAt="
				+ createdAt + ", modifiedAt=" + modifiedAt + "]";
	}
	
	

}
