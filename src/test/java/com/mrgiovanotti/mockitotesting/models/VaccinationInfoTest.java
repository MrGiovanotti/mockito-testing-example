package com.mrgiovanotti.mockitotesting.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class VaccinationInfoTest {

	@Test
	void instanceShouldNotBeNull() {
		Person person = new Person();
		VaccinationInfo vaccinationInfo = new VaccinationInfo(person);
		assertNotNull(vaccinationInfo);
	}

	@Test
	void peopleUnder30ShouldNotBeAbleToReceiveVaccine() {
		Person person = new Person(1, "1717170110", "Giovanny Granda", LocalDate.of(2000, 04, 20), false, null);
		VaccinationInfo vaccinationInfo = new VaccinationInfo(person);
		vaccinationInfo.verifyIfIsVaccineAllowed(() -> LocalDate.of(2023, 01, 16));
		assertFalse(vaccinationInfo.isVaccineAllowed());
		assertEquals("Vaccine not allowed for people under 30", vaccinationInfo.getObservation());
	}

	@Test
	void peopleOver30AndVaccinedShouldNotBeAbleToReceiveVaccine() {
		Person person = new Person(1, "1717170110", "Giovanny Granda", LocalDate.of(1983, 07, 10), true, null);
		VaccinationInfo vaccinationInfo = new VaccinationInfo(person);
		vaccinationInfo.verifyIfIsVaccineAllowed(() -> LocalDate.of(2023, 01, 16));
		assertFalse(vaccinationInfo.isVaccineAllowed());
		assertEquals("Vaccine already applied", vaccinationInfo.getObservation());
	}

	@Test
	void peopleOver30AndNotVaccinedShouldBeAbleToReceiveVaccine() {
		Person person = new Person(1, "1717170110", "Giovanny Granda", LocalDate.of(1983, 07, 10), false, null);
		VaccinationInfo vaccinationInfo = new VaccinationInfo(person);
		vaccinationInfo.verifyIfIsVaccineAllowed(() -> LocalDate.of(2023, 01, 16));
		assertTrue(vaccinationInfo.isVaccineAllowed());
	}

	@Test
	void getPersonTest() {
		Person person = new Person();
		VaccinationInfo vaccinationInfo = new VaccinationInfo(person);
		assertTrue(vaccinationInfo.getPerson() instanceof Person);
	}

	@Test
	void getPersonAgeTest() {
		Person person = new Person(1, "1717170110", "Giovanny Granda", LocalDate.of(1983, 04, 17), false, null);
		VaccinationInfo vaccinationInfo = new VaccinationInfo(person);
		vaccinationInfo.verifyIfIsVaccineAllowed(() -> LocalDate.of(2023, 01, 16));
		assertEquals(39, vaccinationInfo.getPersonAge());
	}

}
