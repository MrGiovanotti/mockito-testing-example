package com.mrgiovanotti.mockitotesting;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MockitoTestingBeans {

	@Bean
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
