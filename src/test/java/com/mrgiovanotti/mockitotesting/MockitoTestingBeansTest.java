package com.mrgiovanotti.mockitotesting;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class MockitoTestingBeansTest {

	@Test
	void restTemplateShouldNotBeNull() {
		MockitoTestingBeans beans = new MockitoTestingBeans();
		assertNotNull(beans.getRestTemplate());
	}

}
