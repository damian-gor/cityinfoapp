package com.cityinfoapp.weatherinfoservice.resources;

import com.cityinfoapp.weatherinfoservice.models.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
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

    @Value("${url.open-weather}")
    private String openWeatherUrl;

    @Value("${url.open-weather.query-params}")
    private String queryParamsUrl;

    @RequestMapping("/city/{cityId}")
    public Weather getWeatherInfo(@PathVariable ("cityId") String cityId) {
        Weather weather = restTemplate.getForObject(
        openWeatherUrl + cityId + queryParamsUrl + appId,
                Weather.class
        );
        return weather;
    }

}
