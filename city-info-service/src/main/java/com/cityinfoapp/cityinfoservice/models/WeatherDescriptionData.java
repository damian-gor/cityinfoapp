package com.cityinfoapp.cityinfoservice.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Current weather description.")
public class WeatherDescriptionData {
    @ApiModelProperty(notes = "Current weather in the selected city")
    private String main;
    @ApiModelProperty(notes = "Shot description of current weather in the selected city")
    private String description;

    @Override
    public String toString() {
        return "WeatherDescriptionData{" +
                "description='" + description + '\'' +
                '}';
    }
}
