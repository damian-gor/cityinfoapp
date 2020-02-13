package com.cityinfoapp.cityinfoservice;

import com.cityinfoapp.cityinfoservice.config.SwaggerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableEurekaClient
@SpringBootApplication
@EnableCircuitBreaker
@EnableSwagger2
public class CityInfoServiceApplication {

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate (){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(CityInfoServiceApplication.class, args);
	}

	@Bean
	public Docket getDocket () {
	return new SwaggerConfiguration().getSwaggerConfiguration();
	}
}
