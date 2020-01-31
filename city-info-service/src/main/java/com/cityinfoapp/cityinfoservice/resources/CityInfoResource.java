package com.cityinfoapp.cityinfoservice.resources;

import com.cityinfoapp.cityinfoservice.models.CityInfo;
import com.cityinfoapp.cityinfoservice.models.Country;
import com.cityinfoapp.cityinfoservice.models.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/info")
@EnableEurekaClient
public class CityInfoResource {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{cityId}")
    public CityInfo getWeatherResponse(@PathVariable("cityId") String cityId) {
        Weather weather = restTemplate.getForObject("http://weather-info-service/weather/city/" + cityId, Weather.class);
        Country country = restTemplate.getForObject("http://country-info-service/country/" + weather.getSys().getCountry(),
                Country.class);

        return new CityInfo(weather, country);
    }
}
