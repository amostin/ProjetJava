/**
 * 
 */
package test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

import model.Rentacar;
import model.Voiture;

/**
 * @author Moi
 *
 */
class RentacarTest {

	/**
	 * Test method for {@link model.Rentacar#addVoitures()}.
	 */
	@Test
	void testAddVoitures() {
		Rentacar c = new Rentacar();
		assertEquals(c.addVoitures().size(), c.getCatalogue().size());
		assertEquals(10, c.getCatalogue().size());
		assertEquals(10, c.addVoitures().size());
		assertNotEquals(11, c.addVoitures().size());
		assertNotEquals(9, c.addVoitures().size());
	}

	/**
	 * Test method for {@link model.Rentacar#addVoiture(java.lang.String, model.Voiture)}.
	 */
	@Test
	void testAddVoiture() {
		Rentacar c = new Rentacar();
		Voiture v = new Voiture(5);
		assertEquals(true, c.addVoiture("nomVoiture_10", v));
	}

	/**
	 * Test method for {@link model.Rentacar#changEtat(int, java.lang.String)}.
	 */
	@Test
	void testChangEtat() {
		Rentacar c = new Rentacar();
		c.changEtat(0, "supprimé");
		assertEquals("supprimé", c.getCatalogue().get("nomVoiture_0").getEtat());
	}

	/**
	 * Test method for {@link model.Rentacar#verif(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	void testVerif() {
		Rentacar c = new Rentacar();
		assertEquals(true, c.verif("reservations", "5", "amb mos"));
	}

	/**
	 * Test method for {@link model.Rentacar#verifReser(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testVerifReser() {
		Rentacar c = new Rentacar();
		assertEquals(true, c.verifReser("5", "amb mos"));
	}

	/**
	 * Test method for {@link model.Rentacar#verifLoc(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testVerifLoc() {
		Rentacar c = new Rentacar();
		assertEquals(true, c.verifLoc("5", "amb mos"));
	}

	/**
	 * Test method for {@link model.Rentacar#verifRestitution(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testVerifRestitution() {
		Rentacar c = new Rentacar();
		assertEquals(true, c.verifRestitution("5", "amb mos"));
	}

	/**
	 * Test method for {@link model.Rentacar#verifKm(double, java.lang.String)}.
	 */
	@Test
	void testVerifKm() {
		Rentacar c = new Rentacar();
		assertEquals(0.0, c.verifKm(85, "2.5"));
		assertEquals(62.5, c.verifKm(125, "2.5"));
	}

	/**
	 * Test method for {@link model.Rentacar#verifDate(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	void testVerifDate() {
		Rentacar c = new Rentacar();
		long[] pasAmende = {5, 0};
		long[] unJourAmende = {5, 1};
		assertArrayEquals(pasAmende, c.verifDate("10/9/2020", "15/9/2020", "15/9/2020"));
		assertArrayEquals(unJourAmende, c.verifDate("10/9/2020", "15/9/2020", "16/9/2020"));
	}

	/**
	 * Test method for {@link model.Rentacar#lireDate(java.lang.String, int)}.
	 */
	@Test
	void testLireDate() {
		Rentacar c = new Rentacar();
		assertEquals("10/9/2020", c.lireDate("reservations", 2));
		assertEquals("15/9/2020", c.lireDate("reservations", 3));
		assertEquals("jour", c.lireDate("reservations", 4));
		assertEquals("0", c.lireDate("locations", 4));
		assertEquals("125", c.lireDate("restitutions", 4));
		assertEquals("300.0", c.lireDate("factures", 4));
	}
}
