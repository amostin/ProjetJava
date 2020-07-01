package view;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JTextField;

import org.junit.jupiter.api.Test;

import model.Employe;
import model.Gerant;
import model.Mecanicien;

class VueTest {

	/**
	 * Cette m�thode v�rifie que le retour est faux si le mdp ne correspond pas et vrai sinon
	 */
	@Test
	void isMdpCorrectTest() {
		RentacarVue r = new RentacarVue();
		JTextField mdpJuste = new JTextField("mdp");
		JTextField mdpFaux = new JTextField("fauxMdp");
		
		Gerant g = new Gerant();
		//r.isMdpCorrect(g.getMdp(), mdpJuste.getText());
		assertTrue(r.isMdpCorrect(g.getMdp(), mdpJuste.getText()));
		assertFalse(r.isMdpCorrect(g.getMdp(), mdpFaux.getText()));
	}
	/**
	 * Cette m�thode modifie le champs "mdp" d'une personne selon sont role
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
