package com.weather_info_for_pincode.Weather_Info_For_Pincode.service;

import com.weather_info_for_pincode.Weather_Info_For_Pincode.client.WeatherDataClient;
import com.weather_info_for_pincode.Weather_Info_For_Pincode.dto.WeatherRequestDTO;
import com.weather_info_for_pincode.Weather_Info_For_Pincode.entity.PinCodeLocation;
import com.weather_info_for_pincode.Weather_Info_For_Pincode.entity.WeatherData;
import com.weather_info_for_pincode.Weather_Info_For_Pincode.repository.PinCodeLocationRepository;
import com.weather_info_for_pincode.Weather_Info_For_Pincode.repository.WeatherDataRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;



@Service
public class WeatherDataService {

    private final PinCodeLocationRepository pinCodeRepo;
    private final WeatherDataRepository weatherDataRepo;
    private final PinCodeLocationService pinService;
    private final WeatherDataClient client;



    WeatherDataService(PinCodeLocationRepository pinCodeRepo, WeatherDataRepository weatherDataRepo, PinCodeLocationService pinService, WeatherDataClient client){
        this.pinCodeRepo=pinCodeRepo;
        this.weatherDataRepo=weatherDataRepo;
        this.pinService=pinService;
        this.client=client;
    }
    public WeatherData getWeatherData(WeatherRequestDTO dto) {
        if (dto.getForDate() != null && dto.getForDate().isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("Future Date Entered!!");
        }
        if (weatherDataRepo.existsByPinCodeAndForDate(dto.getPinCode(), dto.getForDate())) {
            return weatherDataRepo.findByPinCodeAndForDate(dto.getPinCode(), dto.getForDate());
        }
        PinCodeLocation latNLon = pinService.getLatLan(dto.getPinCode());

        Double lat = latNLon.getLatitude();
        Double lon = latNLon.getLongitude();
        WeatherData data = client.fetchWeather(lat, lon);
        data.setPinCode(dto.getPinCode());
        if(dto.getForDate()!=null) {

            data.setForDate(dto.getForDate());
        }
        data.setFetchedAt(LocalDateTime.now());

        return weatherDataRepo.save(data);
    }
}
