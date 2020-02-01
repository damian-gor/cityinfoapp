package com.cityinfoapp.cityinfoservice.services;

import com.cityinfoapp.cityinfoservice.models.CountryId;
import com.cityinfoapp.cityinfoservice.models.Weather;
import com.cityinfoapp.cityinfoservice.models.WeatherDescriptionData;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherInfo {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod="getFallbackWeather", commandProperties={
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000"),
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value="5"),
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="50"),
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="5000")})
    public Weather getWeather(@PathVariable("cityId") String cityId) {
        return restTemplate.getForObject("http://weather-info-service/weather/city/" + cityId, Weather.class);
    }

    public Weather getFallbackWeather(@PathVariable("cityId") String cityId) {
        return new Weather(new CountryId("City " +cityId + " not found."));
    }
}

