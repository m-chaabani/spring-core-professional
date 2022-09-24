package com.mc.gestionformation.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Formateur extends AbstractEntity {

	enum Appreciation {
		GOOD, MIDIUM, BAD
	}

	@Column(name = "FIRST_NAME",length = 60)
	private String nom;

	@Column(name = "LAST_NAME",length = 60)
	private String prenom;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private Appreciation appreciation ;

	@OneToOne(fetch = FetchType.LAZY)
	private Utilisateur user;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "formateur",fetch = FetchType.EAGER )
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
