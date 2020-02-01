package com.cityinfoapp.weatherinfoservice.resources;

import com.cityinfoapp.weatherinfoservice.models.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/weather")
@EnableEurekaClient
@RefreshScope
public class WeatherInfoResource {

    @Value("${app.id}")
    private String appId;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/city/{cityId}")
    public Weather getWeatherInfo(@PathVariable ("cityId") String cityId) {
        Weather weather = restTemplate.getForObject(
        "http://api.openweathermap.org/data/2.5/weather?q=" + cityId + "&units=metric&APPID=" + appId,
                Weather.class
        );
        return weather;
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
