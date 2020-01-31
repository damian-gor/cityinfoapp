package com.cityinfoapp.cityinfoservice.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WeatherDescriptionData {
    private String main;
    private String description;
}
