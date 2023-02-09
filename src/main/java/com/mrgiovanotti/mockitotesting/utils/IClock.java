package com.mrgiovanotti.mockitotesting.utils;

import java.time.LocalDate;

/**
 * This interface was created with the purpose to facilitate the resilience
 * through the time of the JUnit PU for the method getAge()
 *
 * @author mrgiovanotti
 *
 */
@FunctionalInterface
public interface IClock {

	LocalDate now();

}
