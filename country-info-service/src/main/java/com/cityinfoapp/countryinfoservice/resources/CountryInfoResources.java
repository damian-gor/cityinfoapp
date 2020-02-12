package com.cityinfoapp.countryinfoservice.resources;

import com.cityinfoapp.countryinfoservice.models.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/country")
@EnableEurekaClient
@RefreshScope
public class CountryInfoResources {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{countryId}")
    @PreAuthorize("hasAuthority('get_data')")
    public Country getWeatherInfo(@PathVariable("countryId") String countryId) {
        Country country = restTemplate.getForObject("https://restcountries.eu/rest/v2/alpha/" + countryId,
                Country.class);
        return country;
    }
}