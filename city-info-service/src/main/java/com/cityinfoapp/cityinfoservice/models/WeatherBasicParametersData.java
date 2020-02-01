package com.cityinfoapp.cityinfoservice.models;

import lombok.*;

@Setter
@Getter
public class WeatherBasicParametersData {
    private double temp;
    private int pressure;
    private int humidity;
    private double feels_like;

}
