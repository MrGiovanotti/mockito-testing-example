package com.mrgiovanotti.mockitotesting.utils;

import java.time.LocalDate;

public class Clock implements IClock {

	private static Clock instance;

	private Clock() {
	}

	public static Clock getInstance() {
		if (instance == null) {
			instance = new Clock();
		}
		return instance;
	}

	@Override
	public LocalDate now() {
		return LocalDate.now();
	}

}
