package com.cityinfoapp.cityinfoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableEurekaClient
@SpringBootApplication
@EnableCircuitBreaker
@EnableSwagger2
public class CityInfoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CityInfoServiceApplication.class, args);
	}

}
