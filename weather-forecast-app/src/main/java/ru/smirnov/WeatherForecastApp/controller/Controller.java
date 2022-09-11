package ru.smirnov.WeatherForecastApp.controller;


import lombok.AllArgsConstructor;
import net.minidev.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.smirnov.WeatherForecastApp.converters.ObjectToCurrent;
import ru.smirnov.WeatherForecastApp.converters.ObjectToLocation;
import ru.smirnov.WeatherForecastApp.feignClient.GetWeatherInfoFromOpenMap;
import ru.smirnov.WeatherForecastApp.models.Current;
import ru.smirnov.WeatherForecastApp.models.Location;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
@AllArgsConstructor
public class Controller {
    private final ObjectToLocation toLocation;
    private final ObjectToCurrent toCurrent;
    private final GetWeatherInfoFromOpenMap getWeatherInfoFromOpenMap;

    @GetMapping("/{location}")
    public ResponseEntity<Map<String, Object>> getWeatherInfo(@PathVariable("location") String location) {


        Map<String, Object> map = getWeatherInfoFromOpenMap
                .getWeatherInfo(location, "1704e801bfmshe60c417d553cf15p1c1e7fjsnf66267fa3db1", "weatherapi-com.p.rapidapi.com");

        JSONObject jsonObject = new JSONObject(map);

        Map<String, Object> mapToReturn = new HashMap<>();
        mapToReturn.put("location", toLocation.convertToLocation(jsonObject.get("location")));
        mapToReturn.put("current", toCurrent.convertToCurrent(jsonObject.get("current")));

        return ResponseEntity.ok(mapToReturn);
    }
}