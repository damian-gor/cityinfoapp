package com.cityinfoapp.cityinfoservice.models;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Weather {
    private WeatherBasicParametersData main;
    private WeatherDescriptionData[] weather;
    private CountryId sys;

    public Weather(CountryId sys) {
        this.sys = sys;
    }
}

