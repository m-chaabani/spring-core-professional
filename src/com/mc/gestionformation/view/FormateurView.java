package com.mc.gestionformation.view;

import com.mc.gestionformation.controller.FormateurController;
import com.mc.gestionformation.model.Formateur;

public class FormateurView {
	
	public static void main(String[] args) {

		FormateurController controller = new FormateurController();
		Formateur formateur = new Formateur();
		formateur.setNom("Noureddine");
		formateur.setPrenom("BOUBEKEUR");
		controller.setFormateur(formateur);
		controller.BoutonEnregister();

	}

}
