package com.mc.gestionformation.model;

public interface MyInterface {
	public Float getSalaire();

}

class ProxyFormateur implements MyInterface {

	@Override
	public Float getSalaire() {
		Formateur formateur = new Formateur();
		Float salaire = formateur.getSalaire();
		return salaire;
	}

}
