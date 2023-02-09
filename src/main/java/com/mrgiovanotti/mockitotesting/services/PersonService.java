package com.mrgiovanotti.mockitotesting.services;

import java.util.List;
import java.util.Optional;

import com.mrgiovanotti.mockitotesting.models.Person;

public interface PersonService {

	Optional<Person> findById(int id);

	Optional<Person> findByIdentificationNumber(String identificationNumber);

	List<Person> findAll();

}
