package com.mrgiovanotti.mockitotesting.models;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NeighborhoodTest {

	@Test
	void instanceShouldNotBeNull() {

		Neighborhood neighborhood = new Neighborhood();
		assertNotNull(neighborhood);

	}

	@Test
	@DisplayName("Testing getters for Neighborhood class")
	void gettersTest() {
		Neighborhood neighborhood = new Neighborhood(1, "La Ecuatoriana", "NORTH");
		assertAll(() -> assertEquals(1, neighborhood.getId()),
				() -> assertEquals("La Ecuatoriana", neighborhood.getName()),
				() -> assertEquals("NORTH", neighborhood.getCitySector()));

	}

}
