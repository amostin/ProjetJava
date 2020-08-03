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
	 * Ce constructeur appelle la vue pour afficher une premiere fenetre (connexion), il instancie le model, le controller et la vue puis ajoute la vue au controller
	 * @see model.Rentacar#Rentacar()
	 * @see controller.RentacarController#RentacarController(Rentacar)
	 * @see view.ConnexionVue#ConnexionVue(Rentacar, RentacarController)
	 */
	public RentacarMVC() {
		//création catalogue 0-9
		Rentacar model = new Rentacar();
		//acces a add view
		RentacarController ctrlGui = new RentacarController(model);
		//acces a la frame
		RentacarVue gui = new ConnexionVue(model, ctrlGui);
		//lien entre ctrl et connexion
		ctrlGui.addView(gui);
	}
	//recup branche 11
	/**
	 * Cette méthode est le point de départ de l'application et instancie RentacarMVC
	 * @see RentacarMVC#RentacarMVC()
	 * @param args ne reçoit rien en paramètre
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new RentacarMVC();
			}
		});
	}
}
