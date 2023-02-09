package com.mrgiovanotti.mockitotesting.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import com.mrgiovanotti.mockitotesting.models.Person;
import com.mrgiovanotti.mockitotesting.services.PersonService;

// Se puede utilizar esta anotación o la línea comentada en SetUp()
@ExtendWith(MockitoExtension.class)
class VaccinationInfoControllerTest {

	@Mock
	PersonService personService;

	@InjectMocks
	VaccinationInfoController vaccinationInfoController;

	@BeforeEach
	void SetUp() {
		// MockitoAnnotations.openMocks(this);
	}

	@Test
	void getVaccionationInfoByIdPersonTest() {
		Person person = new Person(1, "1717170110", "Giovanny Granda", LocalDate.of(1983, 4, 20), false, null);
		Optional<Person> optionalPerson = Optional.of(person);
		when(personService.findById(anyInt())).thenReturn(optionalPerson);
		assertNotNull(vaccinationInfoController.getVaccionationInfoByIdPerson(1));
		assertEquals(HttpStatus.OK, vaccinationInfoController.getVaccionationInfoByIdPerson(1).getStatusCode());
	}

	@Test
	void getVaccinationInfoByIdentificationNumberTest() {
		Person person = new Person(1, "1717170110", "Giovanny Granda", LocalDate.of(1983, 4, 20), false, null);
		Optional<Person> optionalPerson = Optional.of(person);
		when(personService.findByIdentificationNumber(anyString())).thenReturn(optionalPerson);
		assertNotNull(vaccinationInfoController.getVaccinationInfoByIdentificationNumber("1717170110"));
		assertEquals(HttpStatus.OK,
				vaccinationInfoController.getVaccinationInfoByIdentificationNumber("1717170110").getStatusCode());
	}

	@Test
	void getAllVaccinationInfoTest() {
		Person person1 = new Person(1, "1717170110", "Giovanny Granda", LocalDate.of(1983, 4, 20), false, null);
		Person person2 = new Person(1, "1717170102", "Nocholas Cage", LocalDate.of(2000, 8, 14), false, null);
		List<Person> persons = Arrays.asList(person1, person2);
		when(personService.findAll()).thenReturn(persons);
		assertNotNull(vaccinationInfoController.getAllVaccinationInfo());
		assertEquals(HttpStatus.OK, vaccinationInfoController.getAllVaccinationInfo().getStatusCode());
	}

	@Test
	void ifNotFoundPersonByIdReturnsNotFoound() {
		when(personService.findById(anyInt())).thenReturn(Optional.empty());
		assertEquals(HttpStatus.NOT_FOUND, vaccinationInfoController.getVaccionationInfoByIdPerson(1).getStatusCode());
	}

	@Test
	void ifNotFoundPersonByIdentificationNumberReturnsNotFoound() {
		when(personService.findByIdentificationNumber(anyString())).thenReturn(Optional.empty());
		assertEquals(HttpStatus.NOT_FOUND,
				vaccinationInfoController.getVaccinationInfoByIdentificationNumber("1717170110").getStatusCode());
	}

}
