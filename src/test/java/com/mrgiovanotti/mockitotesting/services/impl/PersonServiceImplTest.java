package com.mrgiovanotti.mockitotesting.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import com.mrgiovanotti.mockitotesting.models.Person;

class PersonServiceImplTest {

	@Mock
	RestTemplate restTemplate;

	@InjectMocks
	PersonServiceImpl personService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void findByIdShouldNotBeNull() {
		String url = "http://192.168.64.2:30003/mockito-third-party/person/view/id/1";
		Person person = new Person(1, "1717170110", "Giovanny Granda", LocalDate.of(1983, 4, 20), false, null);
		when(restTemplate.getForObject(url, Person.class)).thenReturn(person);
		assertNotNull(personService.findById(1));
	}

	@Test
	void nullResultByIdShouldGetsEmptyOptional() {
		String url = "http://192.168.64.2:30003/mockito-third-party/person/view/id/1";
		when(restTemplate.getForObject(url, Person.class)).thenReturn(null);
		Optional<Person> optionalPerson = Optional.empty();
		assertEquals(optionalPerson, personService.findById(1));
	}

	@Test
	void findByIdentificationNumberShouldNotBeNull() {
		String url = "http://192.168.64.2:30003/mockito-third-party/person/view/identification/1717170110";
		Person person = new Person(1, "1717170110", "Giovanny Granda", LocalDate.of(1983, 4, 20), false, null);
		when(restTemplate.getForObject(url, Person.class)).thenReturn(person);
		assertNotNull(personService.findByIdentificationNumber("1717170110"));
	}

	@Test
	void nullResultByIdentificationNumberGetsEmptyOptional() {
		String url = "http://192.168.64.2:30003/mockito-third-party/person/view/identification/1717170110";
		when(restTemplate.getForObject(url, Person.class)).thenReturn(null);
		Optional<Person> optionalPerson = Optional.empty();
		assertEquals(optionalPerson, personService.findByIdentificationNumber("1717170110"));
	}

	@Test
	void findAllReturnsApersonList() {
		String url = "http://192.168.64.2:30003/mockito-third-party/person/list";
		Person person1 = new Person(1, "1717170110", "Giovanny Granda", LocalDate.of(1983, 4, 20), false, null);
		Person person2 = new Person(1, "1717170102", "Nocholas Cage", LocalDate.of(2000, 8, 14), false, null);
		Person[] persons = { person1, person2 };
		when(restTemplate.getForObject(url, Person[].class)).thenReturn(persons);
		assertEquals(2, personService.findAll().size());
	}

}
