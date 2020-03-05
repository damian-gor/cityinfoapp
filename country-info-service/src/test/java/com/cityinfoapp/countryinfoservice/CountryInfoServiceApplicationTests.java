package com.cityinfoapp.countryinfoservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations="classpath:test.yml")
class CountryInfoServiceApplicationTests {

	@Test
	void contextLoads() {
	}

}
