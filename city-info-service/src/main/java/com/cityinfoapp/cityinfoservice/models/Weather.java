package com.cityinfoapp.cityinfoservice.models;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Weather {
    private WeatherBasicParametersData main;
    private WeatherDescriptionData[] weather;
    private CountryId sys;
}

