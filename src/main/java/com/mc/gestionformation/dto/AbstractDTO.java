package com.mc.gestionformation.dto;

import java.util.ArrayList;
import java.util.List;

import com.mc.gestionformation.model.AbstractEntity;
import com.mc.gestionformation.model.Utilisateur;

public abstract class AbstractDTO<T extends AbstractEntity> {
	
	private T entity;
	private List<T> listEntity;
	
	
	
	public AbstractDTO() {
		super();
	}

	public AbstractDTO(T entity) {
		super();
		this.entity = entity;
	}

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

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	public List<T> getListEntity() {
		return listEntity;
	}

	public void setListEntity(List<T> listEntity) {
		this.listEntity = listEntity;
	}
	
	

}
