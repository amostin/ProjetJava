/**
 * 
 */
package rentacar;

import view.RentacarVue;

/**
 * @author Moi
 *
 */
public class RentacarMVC {

	/**
	 * 
	 */
	public RentacarMVC() {
		new RentacarVue();
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new RentacarMVC();
			}
		});
	}
}
