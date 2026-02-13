package com.weather_info_for_pincode.Weather_Info_For_Pincode.repository;

import com.weather_info_for_pincode.Weather_Info_For_Pincode.entity.PinCodeLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PinCodeLocationRepository extends JpaRepository<PinCodeLocation,Long> {

    boolean existsByPinCode(String pinCode);
    PinCodeLocation findByPinCode(String pinCode);

}
