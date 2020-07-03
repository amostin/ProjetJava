/**
 * 
 */
package controller;

import model.Rentacar;
import model.Rentacar;
import model.Voiture;
import view.RentacarVue;

/**
 * Cette classe est utile � lier les composants model, view et controller
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
		model.addVoiture(nomVoiture, voiture);

	}
	
	public void supprimeVehicule(int numVehicule) {
		model.supprimeVehicule(numVehicule);
	}
	

}
