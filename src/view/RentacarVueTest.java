package view;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JTextField;

import org.junit.jupiter.api.Test;

import model.Gerant;

class RentacarVueTest {

	@Test
	void isMdpCorrectTest() {
		RentacarVue r = new RentacarVue();
		
		JTextField mdpJuste = new JTextField("mdp");
		JTextField mdpFaux = new JTextField("fauxMdp");
		Gerant g = new Gerant();
		r.isMdpCorrect(g.getMdp(), mdpJuste.getText());
		assertTrue(r.isMdpCorrect(g.getMdp(), mdpJuste.getText()));
		assertFalse(r.isMdpCorrect(g.getMdp(), mdpFaux.getText()));
	}
}
