package ru.smirnov.WeatherForecastApp.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Condition {
    @JsonProperty("text")
    private String text;
}
