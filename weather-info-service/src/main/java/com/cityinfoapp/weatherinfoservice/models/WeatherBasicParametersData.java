package com.cityinfoapp.weatherinfoservice.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.*;

@Setter
@Getter
public class WeatherBasicParametersData {
    private double temp;
    private int pressure;
    private int humidity;
    @JsonAlias({"feels_like"})
    private double feelsLike;

}
