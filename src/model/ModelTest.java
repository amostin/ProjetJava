package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ModelTest {

	@Test
	void createNomVoituresTest() {
		Rentacar c = new Rentacar(false);
		assertEquals(10, c.createNomVoitures().length);
	}

	@Test
	void createVoituresTest() {
		Rentacar c = new Rentacar(false);
		assertEquals(10, c.createVoitures().length);
	}

	@Test
	void addVoituresTest() {
		Rentacar c = new Rentacar(false);
		assertEquals(10, c.addVoitures(c.createNomVoitures(), c.createVoitures()).size());
	}
}
