package com.mc.gestionformation.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class Formateur extends AbstractEntity {

	@Column(name = "FIRST_NAME")
	private String nom;
	@Column(name = "LAST_NAME")
	private String prenom;

	@Transient
	private Utilisateur user;
	@Transient
	private Set<Formation> formations = new HashSet<Formation>();

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

	public Set<Formation> getFormations() {
		return formations;
	}

	public void setFormations(Set<Formation> formations) {
		this.formations = formations;
	}

	@Override
	@Transient
	public String toString() {
		return "Formateur [nom=" + nom + ", prenom=" + prenom + ", user=" + user + ", id=" + id + ", createdAt="
				+ createdAt + ", modifiedAt=" + modifiedAt + "]";
	}

}
