package com.mc.gestionformation.dto;

import java.util.List;

import com.mc.gestionformation.model.Discipline;
import com.mc.gestionformation.model.Formateur;
import com.mc.gestionformation.model.Formation;

public class FormateurDTO extends AbstractDTO<Formateur> {

	private Discipline discipline;
	private List<Formation> formations;

	public List<Formation> getFormations() {
		return formations;
		
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}

	public Discipline getDiscipline() {
		return discipline;
	}

	public void setDiscipline(Discipline discipline) {
		this.discipline = discipline;
	}

	@Override
	public String toString() {
		return "FormateurDTO [formateur=" + getListEntity() + ", formations=" + formations + "]";
	}

}
