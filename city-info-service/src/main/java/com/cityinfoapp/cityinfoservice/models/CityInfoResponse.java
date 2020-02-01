package com.cityinfoapp.cityinfoservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CityInfoResponse {
    private WeatherDescriptionData[] weatherDescription;
    private double temperature;
    private double temperatureFeelsLike;
    private int pressure;
    private int humidity;

    private String countryName;
    private String capitalName;
    private String subregionName;
    private long countryPopulation;
    private double countryArea;

}
