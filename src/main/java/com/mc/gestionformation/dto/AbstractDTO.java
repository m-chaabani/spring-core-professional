package com.mc.gestionformation.dto;

import java.util.ArrayList;
import java.util.List;

import com.mc.gestionformation.model.Utilisateur;

public abstract class AbstractDTO {
	
	protected Utilisateur utilisateur;
	protected List<String> erreurs = new ArrayList<>();
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public List<String> getErreurs() {
		return erreurs;
	}
	public void setErreurs(List<String> erreurs) {
		this.erreurs = erreurs;
	}
	
	
}
