package com.mrgiovanotti.mockitotesting.models;

import com.mrgiovanotti.mockitotesting.utils.IClock;

import lombok.Getter;

@Getter
public class VaccinationInfo {

	private Person person;
	private boolean vaccineAllowed;
	private String observation;
	private int personAge;

	public VaccinationInfo(Person person) {
		this.person = person;
	}

	public void verifyIfIsVaccineAllowed(IClock clock) {
		personAge = person.getAge(clock);
		if (personAge < 30) {
			vaccineAllowed = false;
			observation = "Vaccine not allowed for people under 30";
		} else if (person.isVaccinated()) {
			vaccineAllowed = false;
			observation = "Vaccine already applied";
		} else {
			vaccineAllowed = true;
		}
	}

}
