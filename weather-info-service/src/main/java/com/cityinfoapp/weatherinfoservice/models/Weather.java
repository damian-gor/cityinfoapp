package com.cityinfoapp.weatherinfoservice.models;

import lombok.*;

@Setter
@Getter
public class Weather {
    private WeatherBasicParametersData main;
    private WeatherDescriptionData[] weather;
    private CountryId sys;
}

