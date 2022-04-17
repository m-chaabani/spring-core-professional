package com.mc.gestionformation.dto;

import java.util.List;

import com.mc.gestionformation.model.Formateur;
import com.mc.gestionformation.model.Formation;

public class FormateurDTO extends AbstractDTO {

	private Formateur formateur;
	private List<Formateur> formateurs;
	private List<Formation> formations;

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	public List<Formation> getFormations() {
		return formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}

	public List<Formateur> getFormateurs() {
		return formateurs;
	}

	public void setFormateurs(List<Formateur> formateurs) {
		this.formateurs = formateurs;
	}
	
	
	
	

}
