/**
 * 
 */
package rentacar;

import view.ModifierMdpVue;
import view.RentacarVue;

/**
 * Cette classe permet de lancer l'application en liant les trois parties MVC.
 * @author Ambroise Mostin
 *
 */
public class RentacarMVC {

	/**
	 * Ce constructeur appel la vue pour afficher une premiere fenetre
	 */
	public RentacarMVC() {
		new RentacarVue();
		//new ModifierMdpVue();
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new RentacarMVC();
			}
		});
	}
}
