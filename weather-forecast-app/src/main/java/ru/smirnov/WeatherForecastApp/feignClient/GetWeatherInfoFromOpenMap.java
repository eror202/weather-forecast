package ru.smirnov.WeatherForecastApp.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@FeignClient(name = "weatherInfo", url = "https://weatherapi-com.p.rapidapi.com", path = "/current.json")
public interface GetWeatherInfoFromOpenMap {

    @RequestMapping(method = RequestMethod.GET, value = "?q={location}",consumes = APPLICATION_JSON_VALUE)
    Map<String,Object> getWeatherInfo(@PathVariable String location,
                                         @RequestHeader("X-RapidAPI-Key") String apiKey,
                                         @RequestHeader("X-RapidAPI-Host") String host);
}
