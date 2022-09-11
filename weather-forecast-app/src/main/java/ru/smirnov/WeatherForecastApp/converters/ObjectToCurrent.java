package ru.smirnov.WeatherForecastApp.converters;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.smirnov.WeatherForecastApp.models.Current;

@Component
@AllArgsConstructor
public class ObjectToCurrent {
    private final ModelMapper modelMapper;

    public Current convertToCurrent(Object object){
        return modelMapper.map(object, Current.class);
    }
}
