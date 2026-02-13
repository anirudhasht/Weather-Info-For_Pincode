package com.weather_info_for_pincode.Weather_Info_For_Pincode.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeatherRequestDTO {
    @NotBlank(message="PinCode must be 6 characters")
    private String pinCode;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime  forDate;

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public LocalDateTime getForDate() {
        return forDate;
    }

    public void setForDate(LocalDateTime forDate) {
        this.forDate = forDate;
    }
}
