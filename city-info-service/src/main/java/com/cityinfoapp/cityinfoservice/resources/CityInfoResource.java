package com.cityinfoapp.cityinfoservice.resources;

import com.cityinfoapp.cityinfoservice.config.AccessToken;
import com.cityinfoapp.cityinfoservice.models.*;
import com.cityinfoapp.cityinfoservice.services.AES;
import com.cityinfoapp.cityinfoservice.services.CountryInfo;
import com.cityinfoapp.cityinfoservice.services.WeatherInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping
@EnableEurekaClient
@RefreshScope
public class CityInfoResource {

    @GetMapping("/admin")
    public String getAdminData(){
        return AES.decrypt(confidentialInfo, secretKey);
    }
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

    @GetMapping("/")
    public String greeting(){
        return greetingMessage + applicationName + ". " + functionalityDescription;
    }
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WeatherInfo weatherInfo;

    @Autowired
    private CountryInfo countryInfo;

    @RequestMapping("/city/{cityId}")
    public CityInfoResponse getWeatherResponse(@PathVariable("cityId") String cityId) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", AccessToken.getAccessToken());
        HttpEntity<Country> countryInfoHttpEntity = new HttpEntity<>(httpHeaders);

        Weather weather = weatherInfo.getWeather(cityId, countryInfoHttpEntity);
        Country country = countryInfo.getCountry(weather, countryInfoHttpEntity);

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

}
