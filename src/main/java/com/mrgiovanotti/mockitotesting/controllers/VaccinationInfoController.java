package com.mrgiovanotti.mockitotesting.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrgiovanotti.mockitotesting.models.Person;
import com.mrgiovanotti.mockitotesting.models.VaccinationInfo;
import com.mrgiovanotti.mockitotesting.services.PersonService;
import com.mrgiovanotti.mockitotesting.utils.Clock;
import com.mrgiovanotti.mockitotesting.utils.IClock;

@RestController
@RequestMapping("/vaccination-info")
public class VaccinationInfoController {

	@Autowired
	PersonService personService;

	IClock clock = Clock.getInstance();

	@GetMapping("/person/id/{id}")
	public ResponseEntity<VaccinationInfo> getVaccionationInfoByIdPerson(@PathVariable int id) {

		Person person = personService.findById(id).orElse(null);

		if (person == null) {
			return ResponseEntity.notFound().build();
		}

		VaccinationInfo vaccinationInfo = new VaccinationInfo(person);
		vaccinationInfo.verifyIfIsVaccineAllowed(clock);
		return ResponseEntity.ok().body(vaccinationInfo);
	}

	@GetMapping("/person/identification/{identificationNumber}")
	public ResponseEntity<VaccinationInfo> getVaccinationInfoByIdentificationNumber(
			@PathVariable String identificationNumber) {

		Person person = personService.findByIdentificationNumber(identificationNumber).orElse(null);

		if (person == null) {
			return ResponseEntity.notFound().build();
		}

		VaccinationInfo vaccinationInfo = new VaccinationInfo(person);
		vaccinationInfo.verifyIfIsVaccineAllowed(clock);
		return ResponseEntity.ok().body(vaccinationInfo);
	}

	@GetMapping("/list")
	public ResponseEntity<List<VaccinationInfo>> getAllVaccinationInfo() {
		List<VaccinationInfo> vaccinationInfoAsList = personService.findAll().stream().map(person -> {
			VaccinationInfo vac = new VaccinationInfo(person);
			vac.verifyIfIsVaccineAllowed(clock);
			return vac;

		}).collect(Collectors.toList());

		return ResponseEntity.ok().body(vaccinationInfoAsList);
	}

}
