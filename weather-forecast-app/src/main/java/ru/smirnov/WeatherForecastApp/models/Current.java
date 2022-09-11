package ru.smirnov.WeatherForecastApp.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Current {
    @JsonProperty("temp_c")
    private String temp_c;
    @JsonProperty("condition")
    private Condition condition;
}
