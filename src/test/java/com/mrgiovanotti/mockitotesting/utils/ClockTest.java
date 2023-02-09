package com.mrgiovanotti.mockitotesting.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class ClockTest {

	@Test
	void test() {
		IClock clock = Clock.getInstance();
		assertTrue(clock instanceof Clock);
		IClock anotherClock = Clock.getInstance();
		assertEquals(clock.hashCode(), anotherClock.hashCode());
	}

	@Test
	void NowTest() {
		LocalDate now = LocalDate.now();
		IClock clock = Clock.getInstance();
		assertEquals(now, clock.now());
	}

}
