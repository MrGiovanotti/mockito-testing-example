package com.mrgiovanotti.mockitotesting.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.mrgiovanotti.mockitotesting.utils.IClock;

import lombok.Getter;

@Getter
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String identificationNumber;
	private String name;
	private LocalDate birthDate;
	private boolean vaccinated;
	private Neighborhood neighborhood;

	public Person() {
	}

	public Person(int id, String identificationNumber, String name, LocalDate birthDate, boolean vaccinated,
			Neighborhood neighborhood) {
		this.id = id;
		this.identificationNumber = identificationNumber;
		this.name = name;
		this.birthDate = birthDate;
		this.vaccinated = vaccinated;
		this.neighborhood = neighborhood;
	}

	public int getAge(IClock clock) {
		return (int) ChronoUnit.YEARS.between(birthDate, clock.now());
	}

}
