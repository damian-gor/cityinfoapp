package com.cityinfoapp.weatherinfoservice.models;

import lombok.*;

@Setter
@Getter
public class WeatherBasicParametersData {
    private String temp;
    private String pressure;
    private String humidity;
    private String feels_like;

}
