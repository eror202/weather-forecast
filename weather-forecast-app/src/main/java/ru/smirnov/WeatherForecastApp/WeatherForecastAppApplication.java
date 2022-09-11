package ru.smirnov.WeatherForecastApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.net.URI;


@SpringBootApplication
@EnableFeignClients
public class WeatherForecastAppApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(WeatherForecastAppApplication.class,args);

	}
}