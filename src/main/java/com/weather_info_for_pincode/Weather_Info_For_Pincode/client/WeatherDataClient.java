package com.weather_info_for_pincode.Weather_Info_For_Pincode.client;

import com.weather_info_for_pincode.Weather_Info_For_Pincode.entity.WeatherData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Map;

@Component
public class WeatherDataClient {
    @Value("${openweather.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public WeatherDataClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherData fetchWeather(Double lat, Double lon) {
        String url = String.format("https://api.openweathermap.org/data/2.5/weather?lat=%s&lon=%s&appid=%s",
                lat,
                lon,
                apiKey);


        Map<String, Object> response = restTemplate.getForObject(url, Map.class);

        if (response == null) return null;


        Map<String, Object> main = (Map<String, Object>) response.get("main");
        Map<String, Object> wind = (Map<String, Object>) response.get("wind");
        List<?> weatherList = (List<?>) response.get("weather");
        Map<String, Object> weatherObj = (Map<String, Object>) weatherList.get(0);


        WeatherData data = new WeatherData();
        data.setTemp(Double.valueOf(main.get("temp").toString()));
        data.setHumidity(Double.valueOf(main.get("humidity").toString()));

        if (wind != null && wind.get("speed") != null) {
            data.setWindSpeed(Double.valueOf(wind.get("speed").toString()));
        }

        data.setCondition(weatherObj.get("main").toString());
        data.setDescription(weatherObj.get("description").toString());

        return data;
    }
}