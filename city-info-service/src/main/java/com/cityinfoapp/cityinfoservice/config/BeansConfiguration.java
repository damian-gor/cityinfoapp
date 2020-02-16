package com.cityinfoapp.cityinfoservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class BeansConfiguration {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate (){
        return new RestTemplate();
    }

    @Bean
    public Docket getDocket () {
        return new SwaggerConfiguration().getSwaggerConfiguration();
    }
}
