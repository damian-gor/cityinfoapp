package com.cityinfoapp.discoveryserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServerApplication {

	@Value("${my.greeting: default value}")
	private static String test;

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryServerApplication.class, args);

		System.out.println(test);
	}

}
