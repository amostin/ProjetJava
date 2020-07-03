/**
 * 
 */
package controller;

import model.Rentacar;
import model.Rentacar;
import model.Voiture;
import view.AjoutVoitureVue;
import view.ConnexionVue;
import view.RentacarVue;

/**
 * Cette classe est utile à lier les composants model, view et controller
 * @author Moi
 *
 */
public class RentacarController {
	//Catalogue model; 
	Rentacar model;
	RentacarVue vue;
	AjoutVoitureVue ajoutVoitureVue;
	
	
	// utilisé par RentacarMVC
	public RentacarController(Rentacar model) {
		this.model = model;
	}

	// utilisé par RentacarMVC
	public void addView(RentacarVue gui) {
		this.vue = gui;
	}
	
	// utilisé par la vue quand un bouton est appuyé
	public void ajoutVoiture(String nomVoiture, Voiture voiture) {
		model.addVoiture(nomVoiture, voiture);
		/*
		if(model.addVoiture(nomVoiture, voiture)){
			vue.affiche("Ajout de " + nomVoiture+ " ok");
			//System.out.println("ok ajout");
		}
		else vue.affiche("Ajout impossible");
		*/ 
	}
	

}
