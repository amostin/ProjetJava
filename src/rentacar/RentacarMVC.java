/**
 * 
 */
package rentacar;

import view.ModifierMdpVue;
import view.RentacarVue;
import controller.RentacarController;
import model.Rentacar;
import view.ConnexionVue;

/**
 * Cette classe permet de lancer l'application en liant les trois parties MVC.
 * @author Ambroise Mostin
 *
 */
public class RentacarMVC {

	/**
	 * Ce constructeur appel la vue pour afficher une premiere fenetre (connexion)
	 */
	public RentacarMVC() {
		//new ConnexionVue();
		Rentacar model = new Rentacar();
		
		RentacarController ctrlGui = new RentacarController(model);
		
		RentacarVue gui = new ConnexionVue(model, ctrlGui);
		
		ctrlGui.addView(gui);
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new RentacarMVC();
			}
		});
	}
}
