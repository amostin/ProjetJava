/**
 * 
 */
package controller;

import model.Catalogue;
import view.RentacarVue;

/**
 * @author Moi
 *
 */
public class RentacarController {
	Catalogue model; 
	RentacarVue vue;
	
	public RentacarController(Catalogue model) {
		this.model = model;
	}

	public void addView(RentacarVue vue) {
		this.vue = vue;
	}
}
