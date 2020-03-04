package com.cityinfoapp.cityinfoservice.services;

import com.cityinfoapp.cityinfoservice.models.Country;
import com.cityinfoapp.cityinfoservice.models.CountryId;
import com.cityinfoapp.cityinfoservice.models.Weather;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${url.weatherService}")
    private String weatherInfoUrl;

    @HystrixCommand(fallbackMethod="getFallbackWeather", commandProperties={
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="6000"),
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value="5"),
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="50"),
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="5000")})
    public Weather getWeather(@PathVariable("cityId") String cityId, HttpEntity<Country> countryInfoHttpEntity) {
        ResponseEntity<Weather> responseEntity= restTemplate.exchange(
                weatherInfoUrl + cityId,
                HttpMethod.GET,
                countryInfoHttpEntity,
                Weather.class);
        return responseEntity.getBody();
    }

    public Weather getFallbackWeather(@PathVariable("cityId") String cityId, HttpEntity<Country> countryInfoHttpEntity) {
        return new Weather(new CountryId("City " +cityId + " not found."));
    }
}

