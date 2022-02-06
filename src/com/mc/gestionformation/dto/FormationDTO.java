package com.mc.gestionformation.dto;

import java.util.List;

import com.mc.gestionformation.model.Discipline;
import com.mc.gestionformation.model.Formation;
import com.mc.gestionformation.model.Support;

public class FormationDTO extends AbstractDTO {
	
	private Formation formation;
	private Discipline discipline;
	private List<Support> supports ;
	
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
	
	

}
