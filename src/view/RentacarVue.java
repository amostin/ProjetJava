/**
 * 
 */
package view;

import java.util.Observer;

import controller.RentacarController;
import model.Rentacar;

/**
 * Cette classe est abstraite et permet à la vue d'être en communication avec le controller et le model
 * @author Ambroise Mostin
 *
 */
public abstract class RentacarVue implements Observer{

	protected Rentacar model;
	protected RentacarController controller;
	/**
	 * Ce constructeur permet de lier la vue au controller et au model et est appelé pour chaque vue
	 * @param model
	 * @param controller
	 */
	RentacarVue(Rentacar model, RentacarController controller) {
		this.model = model;
		this.controller = controller;
		model.addObserver(this);
	}
	
	public abstract void affiche(String string) ;

}
