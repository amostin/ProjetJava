/**
 * 
 */
package view;

import java.util.Observer;

import controller.RentacarController;
import model.Rentacar;

/**
 * @author Moi
 *
 */
public abstract class RentacarVue implements Observer{

	protected Rentacar model;
	protected RentacarController controller;
	
	RentacarVue(Rentacar model, RentacarController controller) {
		this.model = model;
		this.controller = controller;
		model.addObserver(this);
	}
	
	public abstract void affiche(String string) ;

}
