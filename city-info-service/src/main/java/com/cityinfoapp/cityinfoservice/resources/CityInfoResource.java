package com.cityinfoapp.cityinfoservice.resources;

import com.cityinfoapp.cityinfoservice.models.*;
import com.cityinfoapp.cityinfoservice.services.CountryInfo;
import com.cityinfoapp.cityinfoservice.services.WeatherInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping("/city")
@EnableEurekaClient
@RefreshScope
public class CityInfoResource {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WeatherInfo weatherInfo;

    @Autowired
    private CountryInfo countryInfo;

    @RequestMapping("/{cityId}")
    public CityInfoResponse getWeatherResponse(@PathVariable("cityId") String cityId) {
        Weather weather = weatherInfo.getWeather(cityId);
        Country country = countryInfo.getCountry(weather);

        return new CityInfoResponse(
                weather.getWeather(),
                weather.getMain().getTemp(),
                weather.getMain().getFeels_like(),
                weather.getMain().getPressure(),
                weather.getMain().getHumidity(),
                country.getName(),
                country.getCapital(),
                country.getSubregion(),
                country.getPopulation(),
                country.getArea());
    }

    @Value("${greeting: Welcome in our service.}")
    private String greetingMessage;

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${functionalityDescription}")
    private String functionalityDescription;

    @GetMapping("/greeting")
    public String greeting(){
        return greetingMessage + applicationName + ". " + functionalityDescription;
    }

}
