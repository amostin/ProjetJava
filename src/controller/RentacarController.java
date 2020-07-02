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
	
	
	// utilis� par RentacarMVC
	public RentacarController(Rentacar model) {
		this.model = model;
	}

	// utilis� par RentacarMVC
	public void addView(RentacarVue gui) {
		this.vue = gui;
	}
	
	// utilis� par la vue quand un bouton est appuy�
	public void ajoutVoiture(String nomVoiture, Voiture voiture) {
		if(model.addVoiture(nomVoiture, voiture)){
			vue.affiche("Ajout de" + nomVoiture+ "ok");
		}
		else vue.affiche("Ajout impossible");
		//TODO 
	}
}
