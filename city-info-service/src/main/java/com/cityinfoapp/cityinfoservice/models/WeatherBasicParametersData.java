package com.cityinfoapp.cityinfoservice.models;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WeatherBasicParametersData {
    private String temp;
    private String pressure;
    private String humidity;
    private String feels_like;

}
