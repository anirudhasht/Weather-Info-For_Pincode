package com.weather_info_for_pincode.Weather_Info_For_Pincode.repository;

import com.weather_info_for_pincode.Weather_Info_For_Pincode.entity.WeatherData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherDataRepository extends JpaRepository<WeatherData,Long> {
    boolean existsByPinCode(String pinCode);

    WeatherData findByPinCode(String pinCode);

}
