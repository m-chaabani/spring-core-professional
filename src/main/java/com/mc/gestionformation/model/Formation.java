package com.mc.gestionformation.model;

import java.time.Duration;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Formation extends AbstractEntity {

	@NotNull(message = "Le code de la formation ne doit pas etre null")
	private String code;
	@NotNull(message = "Le code de la formation ne doit pas etre null")
	private String titre;

	@Size(min = 10, max = 500, message = "#{formation.description.error}")
	private String description;
	
	private String preprequis;
	
	private Duration duree;

	@ManyToOne
	@JoinColumn(name = "formateur_id", referencedColumnName = "id")
	private Formateur formateur;

	@ManyToOne
	@JoinColumn(name = "discipline_id", referencedColumnName = "id")
	private Discipline discipline;


	public Formation() {
		
	}
	
	public Formation(Long id) {
		super(id);
	
	}


	public Formation(String code, String title) {
		this.code = code;
		this.titre = title ;
	}

	public Formation(Long id, String version, LocalDate createdAt, LocalDate modifiedAt) {
		super(id, version, createdAt, modifiedAt);
		// TODO Auto-generated constructor stub
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPreprequis() {
		return preprequis;
	}

	public void setPreprequis(String preprequis) {
		this.preprequis = preprequis;
	}

	public Duration getDuree() {
		return duree;
	}

	public void setDuree(Duration duree) {
		this.duree = duree;
	}

	public Discipline getDiscipline() {
		return discipline;
	}

	public void setDiscipline(Discipline discipline) {
		this.discipline = discipline;
	}

	
	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	@Override
	public String toString() {
		return "Formation [code=" + code + ", titre=" + titre + ", id=" + id + "]";
	}

}
