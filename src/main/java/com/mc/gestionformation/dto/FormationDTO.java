package com.mc.gestionformation.dto;

import java.util.List;

import com.mc.gestionformation.model.Discipline;
import com.mc.gestionformation.model.Formateur;
import com.mc.gestionformation.model.Formation;
import com.mc.gestionformation.model.Support;

public class FormationDTO extends AbstractDTO {

	private Formation formation;
	private Formateur formateur;
	private Discipline discipline;
	private List<Support> supports;
	private List<Formation> formations;

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public Discipline getDiscipline() {
		return discipline;
	}

	public void setDiscipline(Discipline discipline) {
		this.discipline = discipline;
	}

	public List<Support> getSupports() {
		return supports;
	}

	public void setSupports(List<Support> supports) {
		this.supports = supports;
	}

	public List<Formation> getFormations() {
		return formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

}
