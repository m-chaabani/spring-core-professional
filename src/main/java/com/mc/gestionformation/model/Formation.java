package com.mc.gestionformation.model;

import java.time.Duration;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Formation extends AbstractEntity {

	private String code;
	private String titre;
	private String description;
	private String preprequis;
	private Duration duree;
	private Discipline discipline;

	private Set<Formation> formations = new HashSet<Formation>();

	public Formation() {
		// TODO Auto-generated constructor stub
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

	public Set<Formation> getFormations() {
		return formations;
	}

	public void setFormations(Set<Formation> formations) {
		this.formations = formations;
	}

}
