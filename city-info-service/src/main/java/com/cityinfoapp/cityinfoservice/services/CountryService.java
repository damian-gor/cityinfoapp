package com.cityinfoapp.cityinfoservice.services;

import com.cityinfoapp.cityinfoservice.models.Country;
import com.cityinfoapp.cityinfoservice.models.Weather;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CountryService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${url.countryService}")
    private String countryInfoUrl;

    @HystrixCommand(fallbackMethod = "getFallbackCountry", commandProperties={
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000"),
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value="5"),
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="50"),
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="5000")})
    public Country getCountry(Weather weather, HttpEntity<Country> countryInfoHttpEntity) {
        ResponseEntity<Country> responseEntity=restTemplate.exchange(
                countryInfoUrl + weather.getSys().getCountry(),
                HttpMethod.GET,
                countryInfoHttpEntity,
                Country.class);
        return responseEntity.getBody();
    }

    public Country getFallbackCountry(Weather weather, HttpEntity<Country> countryInfoHttpEntity) {
        return new Country("Country not found","","", 0, 0);
    }
}
