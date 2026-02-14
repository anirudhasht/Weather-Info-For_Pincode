package com.weather_info_for_pincode.Weather_Info_For_Pincode.repository;

import com.weather_info_for_pincode.Weather_Info_For_Pincode.entity.WeatherData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface WeatherDataRepository extends JpaRepository<WeatherData,Long> {
    boolean existsByPinCode(String pinCode);
    boolean existsByPinCodeAndForDate(String pinCode, LocalDateTime forDate);

    WeatherData findByPinCodeAndForDate(String pinCode,LocalDateTime forDate);

}
