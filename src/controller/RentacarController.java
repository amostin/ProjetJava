/**
 * 
 */
package controller;

import model.Rentacar;
import model.Rentacar;
import model.Voiture;
import view.ConnexionVue;
import view.RentacarVue;

/**
 * @author Moi
 *
 */
public class RentacarController {
	//Catalogue model; 
	Rentacar model;
	RentacarVue vue;
	
	
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
		if(model.addVoiture(nomVoiture, voiture)){
			vue.affiche("Ajout de" + nomVoiture+ "ok");
		}
		else vue.affiche("Ajout impossible");
		//TODO 
	}
}
