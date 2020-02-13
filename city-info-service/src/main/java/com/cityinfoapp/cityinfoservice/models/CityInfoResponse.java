package com.cityinfoapp.cityinfoservice.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@ApiModel(description = "Details about the selected city (its country & current weather info)")
public class CityInfoResponse {
    private WeatherDescriptionData[] weatherDescription;
    @ApiModelProperty(notes = "Current temperature in the selected city.")
    private double temperature;
    @ApiModelProperty(notes = "Current temperature felt in the selected city.")
    private double temperatureFeelsLike;
    @ApiModelProperty(notes = "Current pressure in the selected city.")
    private int pressure;
    @ApiModelProperty(notes = "Current humidity in the selected city.")
    private int humidity;
    @ApiModelProperty(notes = "Name of the selected city's country.")
    private String countryName;
    @ApiModelProperty(notes = "Name of the selected city's country capital.")
    private String capitalName;
    @ApiModelProperty(notes = "Name of the selected city's subregion.")
    private String subregionName;
    @ApiModelProperty(notes = "Population of the selected city's country.")
    private long countryPopulation;
    @ApiModelProperty(notes = "Area of the selected city's country [km2].")
    private double countryArea;

}
