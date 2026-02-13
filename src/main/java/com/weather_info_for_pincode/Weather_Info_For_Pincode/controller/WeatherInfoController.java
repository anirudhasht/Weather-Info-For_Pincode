package com.weather_info_for_pincode.Weather_Info_For_Pincode.controller;

import com.weather_info_for_pincode.Weather_Info_For_Pincode.dto.WeatherRequestDTO;
import com.weather_info_for_pincode.Weather_Info_For_Pincode.entity.WeatherData;
import com.weather_info_for_pincode.Weather_Info_For_Pincode.service.WeatherDataService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WeatherInfoController {
    private final WeatherDataService service;
    WeatherInfoController(WeatherDataService service){
        this.service=service;
    }

    @PostMapping("/getWeather")
    public ResponseEntity<WeatherData> getWeather(@Valid @RequestBody WeatherRequestDTO dto) {

        WeatherData data = service.getWeatherData(dto);
        return ResponseEntity.ok(data);
    }



    }

