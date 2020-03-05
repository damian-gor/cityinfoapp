package com.cityinfoapp.authorizationserver;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations="classpath:test.yml")
class AuthorizationServerApplicationTests {

	@Test
	void contextLoads() {
	}

}
