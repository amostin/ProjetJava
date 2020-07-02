package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ModelTest {

	@Test
	void createNomVoituresTest() {
		Catalogue c = new Catalogue(false);
		assertEquals(10, c.createNomVoitures(10).length);
	}

	@Test
	void createVoituresTest() {
		Catalogue c = new Catalogue(false);
		assertEquals(10, c.createVoitures(10).length);
	}

	@Test
	void addVoituresTest() {
		Catalogue c = new Catalogue(false);
		assertEquals(10, c.addVoitures(c.createNomVoitures(10), c.createVoitures(10)).size());
	}
}
