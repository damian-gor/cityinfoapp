package com.cityinfoapp.cityinfoservice.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WeatherDescriptionData {
    private String main;
    private String description;

    @Override
    public String toString() {
        return "WeatherDescriptionData{" +
                "description='" + description + '\'' +
                '}';
    }
}
