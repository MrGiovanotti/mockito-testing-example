package com.mrgiovanotti.mockitotesting.models;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PersonTest {

	static Person person1;
	static Person person2;

	@BeforeAll
	static void setUp() {
		person1 = new Person(1, "1717170110", "Giovanny Granda", LocalDate.of(1983, 04, 20), false, null);
		person2 = new Person(2, "1717170110", "Giovanny Granda", LocalDate.of(2000, 12, 31), false, null);
	}

	@Test
	void emptyConstructorTest() {
		Person person = new Person();
		assertNotNull(person);
	}

	@Test
	@DisplayName("Testing getters for Person class")
	void GettersTest() {
		assertAll(

				() -> assertEquals(1, person1.getId()),
				() -> assertEquals("1717170110", person1.getIdentificationNumber()),
				() -> assertEquals("Giovanny Granda", person1.getName()),
				() -> assertEquals(LocalDate.of(1983, 04, 20), person1.getBirthDate()),
				() -> assertFalse(person1.isVaccinated()), () -> assertNull(person1.getNeighborhood()));
	}

	@Test
	void getAgeTest1() {
		assertEquals(39, person1.getAge(() -> LocalDate.of(2022, 12, 27)));
	}

	@Test
	void getAgeTest2() {
		assertEquals(21, person2.getAge(() -> LocalDate.of(2022, 12, 27)));
	}

}
