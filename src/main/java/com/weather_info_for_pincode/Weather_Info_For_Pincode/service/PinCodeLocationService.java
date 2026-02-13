package com.weather_info_for_pincode.Weather_Info_For_Pincode.service;

import com.weather_info_for_pincode.Weather_Info_For_Pincode.entity.PinCodeLocation;
import com.weather_info_for_pincode.Weather_Info_For_Pincode.repository.PinCodeLocationRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class PinCodeLocationService {
    private final PinCodeLocationRepository pinCodeRepo;
    PinCodeLocationService(PinCodeLocationRepository pinCodeRepo){
        this.pinCodeRepo=pinCodeRepo;
    }


    @Value("${openweather.api.key}")
    private String apiKey;

    public PinCodeLocation getLatLan(String pinCode) {
        if(pinCodeRepo.existsByPinCode(pinCode)){
            return pinCodeRepo.findByPinCode(pinCode);
        }

        String url = "http://api.openweathermap.org/geo/1.0/zip"
                + "?zip=" + pinCode + ",IN"
                + "&appid=" + apiKey;

        RestTemplate restTemplate = new RestTemplate();

        Map response = restTemplate.getForObject(url, Map.class);

        Double lat = Double.valueOf(response.get("lat").toString());
        Double lon = Double.valueOf(response.get("lon").toString());

        PinCodeLocation location = new PinCodeLocation();
        location.setPinCode(pinCode);
        location.setLatitude(lat);
        location.setLongitude(lon);

        pinCodeRepo.save(location);

        return location;
    }
}
