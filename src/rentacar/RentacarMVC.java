/**
 * 
 */
package rentacar;

import view.ModifierMdpVue;
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
		new ConnexionVue();
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
