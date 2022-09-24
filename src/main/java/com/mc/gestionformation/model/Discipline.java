package com.mc.gestionformation.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "DISCIPLINE" )
public class Discipline extends AbstractEntity {

	@Column(name = "DISCIPLINE_CODE")
	private String code;
	private String libelle;
	
	
	//attribut dérivé , utilsé qu'au au niveau de l'application
	@Transient
	private String intitule = code + "-" + libelle; 
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "discipline",fetch = FetchType.EAGER )
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

	@Override
	public String toString() {
		return "Discipline [code=" + code + ", libelle=" + libelle + ",  createdAt=" + createdAt
				+ ", modifiedAt=" + modifiedAt + "]";
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	
	
	

}
