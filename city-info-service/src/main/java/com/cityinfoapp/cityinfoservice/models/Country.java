package com.cityinfoapp.cityinfoservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Country {
    private String name;
    private String capital;
    private String subregion;
    private long population;
    private double area;
}
