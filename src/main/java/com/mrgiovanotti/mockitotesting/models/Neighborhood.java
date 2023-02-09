package com.mrgiovanotti.mockitotesting.models;

import java.io.Serializable;

import lombok.Getter;

@Getter
public class Neighborhood implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private String citySector;

	public Neighborhood() {
	}

	public Neighborhood(int id, String name, String citySector) {
		this.id = id;
		this.name = name;
		this.citySector = citySector;
	}

}
