package com.mc.gestionformation.dto;

import java.util.ArrayList;
import java.util.List;

import com.mc.gestionformation.model.Utilisateur;

public abstract class AbstractDTO {
	
	protected List<Throwable> erreurs = new ArrayList<>();
	protected boolean hasErros;
	
	protected Utilisateur utilisateur;
	
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public List<Throwable> getErreurs() {
		return erreurs;
	}
	public void setErreurs(List<Throwable> erreurs) {
		this.erreurs = erreurs;
	}
	
	public boolean isHasErros() {
		return hasErros;
	}
	public void setHasErros(boolean hasErros) {
		this.hasErros = hasErros;
	}
	
	
}
