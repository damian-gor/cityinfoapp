package com.cityinfoapp.cityinfoservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Country {
    private String name;
    private String capital;
    private String subregion;
    private long population;
    private double area;
}
