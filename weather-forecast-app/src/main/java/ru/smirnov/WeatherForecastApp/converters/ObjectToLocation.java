package ru.smirnov.WeatherForecastApp.converters;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.smirnov.WeatherForecastApp.models.Location;

@AllArgsConstructor
@Component
public class ObjectToLocation {
    private final ModelMapper modelMapper;

    public Location convertToLocation(Object object){
        return modelMapper.map(object, Location.class);
    }
}
