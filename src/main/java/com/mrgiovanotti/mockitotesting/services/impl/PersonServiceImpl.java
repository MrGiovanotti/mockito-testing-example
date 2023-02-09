package com.mrgiovanotti.mockitotesting.services.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mrgiovanotti.mockitotesting.models.Person;
import com.mrgiovanotti.mockitotesting.services.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	RestTemplate restTemplate;

	private static final String BASE_URL = "http://192.168.64.2:30003/mockito-third-party/person";

	@Override
	public Optional<Person> findById(int id) {

		String url = BASE_URL + "/view/id/" + id;
		Person result = restTemplate.getForObject(url, Person.class);
		if (result != null) {
			return Optional.of(result);
		}
		return Optional.empty();
	}

	@Override
	public Optional<Person> findByIdentificationNumber(String identificationNumber) {
		String url = BASE_URL + "/view/identification/" + identificationNumber;
		Person result = restTemplate.getForObject(url, Person.class);
		if (result != null) {
			return Optional.of(result);
		}
		return Optional.empty();
	}

	@Override
	public List<Person> findAll() {

		String url = BASE_URL + "/list";
		return Arrays.asList(restTemplate.getForObject(url, Person[].class));

	}

}
