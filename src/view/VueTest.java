package view;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JTextField;

import org.junit.jupiter.api.Test;

import controller.RentacarController;
import model.Employe;
import model.Gerant;
import model.Mecanicien;
import model.Rentacar;

class VueTest {

	/**
	 * Cette méthode vérifie que le retour est faux si le mdp ne correspond pas et vrai sinon
	 */
	@Test
	void isMdpCorrectTest() {
		Rentacar model = new Rentacar();
		RentacarController controller = new RentacarController(model);
		ConnexionVue r = new ConnexionVue(model, controller);
		JTextField mdpJuste = new JTextField("mdp");
		JTextField mdpFaux = new JTextField("fauxMdp");
		
		Gerant g = new Gerant();
		//r.isMdpCorrect(g.getMdp(), mdpJuste.getText());
		assertTrue(r.isMdpCorrect(g.getMdp(), mdpJuste.getText()));
		assertFalse(r.isMdpCorrect(g.getMdp(), mdpFaux.getText()));
	}
	/**
	 * Cette méthode modifie le champs "mdp" d'une personne selon sont role
	 */
	@Test
	void modifMdpTest() {
		//ModifierMdpVue m = new ModifierMdpVue();
		//JTextField mdpJuste = new JTextField("mdp");
		JTextField newMdp = new JTextField("newMdp");
		
		Gerant g = new Gerant();
		assertEquals("mdp", g.getMdp());
		g.setMdp(newMdp.getText());
		assertEquals("newMdp", g.getMdp());
	}
}
