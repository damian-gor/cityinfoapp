package com.cityinfoapp.cityinfoservice.resources;

import com.cityinfoapp.cityinfoservice.config.AccessToken;
import com.cityinfoapp.cityinfoservice.models.*;
import com.cityinfoapp.cityinfoservice.services.AES;
import com.cityinfoapp.cityinfoservice.services.CountryService;
import com.cityinfoapp.cityinfoservice.services.WeatherService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableEurekaClient
@RefreshScope
public class CityInfoResource {

    @GetMapping("/")
    @ApiOperation(value= "Homepage",
            notes = "Available to everyone.",
            response = String.class)
    public String greeting(){
        return greetingMessage + applicationName + ". " + functionalityDescription;
    }

    @GetMapping("/admin")
    @ApiOperation(value= "Decrypts secret information intended only for the Administrator",
            response = String.class)
    public String getAdminData(){
        return AES.decrypt(confidentialInfo, secretKey);
    }

    @GetMapping("/city/{cityId}")
    @ApiOperation(value= "Provides info about selected city",
            notes = "Info about current weather and country.",
            response = CityInfoResponse.class)
    public CityInfoResponse getWeatherResponse(@ApiParam(value= "Name of the city about which you want to receive information",
            required = true) @PathVariable("cityId") String cityId) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", AccessToken.getAccessToken());
        HttpEntity<Country> countryInfoHttpEntity = new HttpEntity<>(httpHeaders);

        Weather weather = weatherService.getWeather(cityId, countryInfoHttpEntity);
        Country country = countryService.getCountry(weather, countryInfoHttpEntity);

        return new CityInfoResponse(
                weather.getWeather(),
                weather.getMain().getTemp(),
                weather.getMain().getFeelsLike(),
                weather.getMain().getPressure(),
                weather.getMain().getHumidity(),
                country.getName(),
                country.getCapital(),
                country.getSubregion(),
                country.getPopulation(),
                country.getArea());
    }

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private CountryService countryService;

    @Value("${spring.admin.secret-info: ***** Confidential information *****}")
    private String confidentialInfo;

    @Value("${spring.admin.secret-key}")
    private String secretKey;

    @Value("${greeting: Welcome in our service.}")
    private String greetingMessage;

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${functionalityDescription}")
    private String functionalityDescription;
}
