package com.cityinfoapp.cityinfoservice.models;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CityInfo {
    private Weather weather;
    private Country country;
}
