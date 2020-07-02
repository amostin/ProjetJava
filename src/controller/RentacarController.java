/**
 * 
 */
package controller;

import model.Catalogue;
import model.Voiture;
import view.ConnexionVue;

/**
 * @author Moi
 *
 */
public class RentacarController {
	Catalogue model; 
	ConnexionVue vue;
	
	// utilis� par RentacarMVC
	public RentacarController(Catalogue model) {
		this.model = model;
	}

	// utilis� par RentacarMVC
	public void addView(ConnexionVue vue) {
		this.vue = vue;
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
